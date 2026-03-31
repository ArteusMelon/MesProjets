package com.example.EDLB.security;

import java.io.IOException;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.EDLB.models.entities.User;
import com.example.EDLB.models.security.Token;
import com.example.EDLB.repositories.JPA.RepositoryUser;
import com.example.EDLB.services.security.JwtService;
import com.example.EDLB.services.security.TokenService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter{

  private final JwtService jwtService;
  private final UserDetailsService userDetailsService;
  private final TokenService tokenService;
  private final RepositoryUser usrRepo;

  @Override
  protected void doFilterInternal(HttpServletRequest request,
                                  HttpServletResponse response,
                                  FilterChain filterChain) throws ServletException, IOException {
    // On récupère le header Authorisation
    String authHeader = request.getHeader("Authorization");

    // Vérifier si le header est présent et commence par bearer
    if(authHeader == null || !authHeader.startsWith("Bearer ")){
      filterChain.doFilter(request, response);
      return;
    }

    //On extrait le token
    String token = authHeader.substring(7); //On retire "Bearer "
    String username = jwtService.extractUsername(token); // On extrait le userName du token grace au service créé

    // On vérifie si l'utilisateur est pas deja authentifié
    if (username != null && SecurityContextHolder.getContext().getAuthentication() == null){
      UserDetails userDetails = userDetailsService.loadUserByUsername(username); // De notre UserDetailCustome (override de la methode loadBy de spring secu)
      //User user = usrRepo.
      //TODO: Refresh le token utilisateur + token de la BDD si le token utilisateur est expiré et celui en base non
      // On vérifie si le token est valid
      //Token tokenBDD = tokenService.findByEmail(username);
      if (jwtService.isTokenValid(token, userDetails)){
        UsernamePasswordAuthenticationToken authToken =
          new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities()); //Si le token est valide : On fait de la magie noire
        authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request)); //TODO: Demander a meussieu de expliquer
        SecurityContextHolder.getContext().setAuthentication(authToken);
      }
      
      
    }
    filterChain.doFilter(request, response);
  }
}
