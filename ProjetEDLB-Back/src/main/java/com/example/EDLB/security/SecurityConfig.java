package com.example.EDLB.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.example.EDLB.repositories.JPA.RepositoryUser;
import com.example.EDLB.services.security.CustomUserDetailsService;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

 // private final UserDetailsService userDetailsService;
  private final CustomUserDetailsService customUserDetailsService;

  // @Bean
  // public UserDetailsService userDetailsService(RepositoryUser userRepository){
  //   return new CustomUserDetailsService(userRepository);
  // }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http, JwtAuthenticationFilter jwtAuthFilter) throws Exception {

    http
      .cors(cors -> cors.configurationSource(request -> corsConfigurationSource())) // Ajout de la gestion des CORS
      .csrf(csrf -> csrf.disable()) // Désaction la protection csr car c'est une api rest
      .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) //Désactive les sessions
      .authorizeHttpRequests(auth -> auth
        .requestMatchers("/api/auth/**").permitAll() // autorise les endpoints d'authentification
        .requestMatchers(HttpMethod.GET, "/api/publications/**").permitAll() // autorise les endpoints des GET publications
        .requestMatchers(HttpMethod.POST, "/api/publications/**").hasAnyAuthority("Dog Owner") // autorise les endpoints des POST publications
        .requestMatchers(HttpMethod.GET, "/api/comments/**").permitAll() // autorise les endpoints des GET commentaires
        .requestMatchers(HttpMethod.POST, "/api/comments/**").hasAnyAuthority("Dog Owner") // autorise les endpoints des POST Commentaire
        .requestMatchers(HttpMethod.GET, "/api/reactions/**").permitAll() // autorise les endpoints des GET reactions
        .requestMatchers(HttpMethod.POST, "/api/reactions/**").hasAnyAuthority("Dog Owner") // autorise les endpoints des GET reactions
        .requestMatchers(HttpMethod.GET, "/api/articles/**").permitAll() // autorise les endpoints des GET articles
        .requestMatchers(HttpMethod.GET, "/api/profile/**").hasAnyAuthority("New Register", "User") // autorise les endpoints des GET articles


        .requestMatchers("/api/**").hasAnyAuthority("Admin", "Developer")
        .anyRequest().authenticated()//tout le reste necessite un authentification
      )
      .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class); //On ajoute le filtre JWT
      
    return http.build();

  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder(); // Encode les mdp en Bcrypt
  }

  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
      return authConfig.getAuthenticationManager();
  }
  @Bean
  public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfigurationSource());
        return new CorsFilter(source);
  }

  private CorsConfiguration corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(List.of("http://localhost:5173")); // Frontend autorisé
        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        config.setAllowedHeaders(List.of("Authorization", "Content-Type"));
        config.setAllowCredentials(true);
        return config;
    }

}
