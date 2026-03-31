// package com.example.EDLB.config.old;

// import java.util.Arrays;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.http.HttpMethod;
// import org.springframework.security.authentication.AuthenticationProvider;
// import org.springframework.security.config.Customizer;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.http.SessionCreationPolicy;
// import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
// import org.springframework.web.cors.CorsConfiguration;
// import org.springframework.web.cors.CorsConfigurationSource;
// import org.springframework.web.cors.UrlBasedCorsConfigurationSource; 


// @Configuration 
// @EnableWebSecurity 
// public  class  SecurityConfiguration { 
//     private  final AuthenticationProvider authenticationProvider; 
//     private  final JwtAuthenticationFilter jwtAuthenticationFilter; 

//     public  SecurityConfiguration ( 
//         JwtAuthenticationFilter jwtAuthenticationFilter, 
//         AuthenticationProvider authenticationProvider 
//     ) { 
//         this .authenticationProvider = authenticationProvider; 
//         this .jwtAuthenticationFilter = jwtAuthenticationFilter; 
//     } 

//     @Bean 
//     public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

//         // Le code suivant permet de modifier la chaîne de filtres afin de :
//         // - autoriser toutes les requêtes sur le endpoint 'login'
//         // - autoriser les requêtes sur le endpoint 'users' uniquement si l'utilisateur
//         // a le "ROLE_ADMIN" et qu'il est authentifié
//         // - ajouter les filtre d'authorisation et d'authentification

//         http.cors(cors -> cors.configurationSource(corsConfigurationSource()))
//                 .csrf(csrf -> csrf.disable()) // désactivation de la vérification par défaut des attaques CSRF (pas
//                                               // grave vu
//                                               // qu'on va mettre en place un système de jetons)
//                 .authorizeHttpRequests((authz) -> authz
//                         .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
//                         .requestMatchers(HttpMethod.POST, "/auth/**").permitAll()
//                         .requestMatchers(HttpMethod.GET, "/error").permitAll()
//                         .anyRequest().authenticated())
//                 .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                 .authenticationProvider(authenticationProvider)
//                 .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
//                 .headers(headers -> headers.cacheControl(Customizer.withDefaults()));

//         return http.build();
//     }

//     @Bean
//     CorsConfigurationSource corsConfigurationSource() {
//         CorsConfiguration config = new CorsConfiguration();
//         config.setAllowedOrigins(Arrays.asList("*"));
//         config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH"));
//         config.setAllowCredentials(false);
//         config.setAllowedHeaders(Arrays.asList("Content-Type", "Authorization", "Accept"));
//         config.setExposedHeaders(Arrays.asList("Access_token", "refresh_token"));

//         UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//         source.registerCorsConfiguration("/**", config);

//         return source;
//     }
// }

