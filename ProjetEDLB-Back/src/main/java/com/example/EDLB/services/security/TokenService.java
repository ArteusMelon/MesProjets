package com.example.EDLB.services.security;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.EDLB.Enum.TokenName;
import com.example.EDLB.models.entities.User;
import com.example.EDLB.models.security.Token;
import com.example.EDLB.repositories.JPA.RepositoryUser;
import com.example.EDLB.repositories.JPA.Security.TokenRepository;
import com.example.EDLB.services.postgre.IServicePostgre;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TokenService implements IServicePostgre<Token>{
  private final TokenRepository tokenRepo;
  private final RepositoryUser usrRepo;
  private final CustomUserDetailsService customUserDetailsService;
  private final JwtService jwtService;

  public Token createRefreshToken(String token, User usr){
    Instant expiration = Instant.now().plus(7, ChronoUnit.DAYS);
    Instant createdAt = Instant.now();

      return Token.builder()
              .expiration(expiration)
              .createdAt(createdAt)
              .tokenName(TokenName.refresh_token)
              .tokenValue(token)
              .user(usr)
              .build();
  } //TODO: Mettre dans une factory ????

  public Token findByEmail(String email){
    User usr = usrRepo.findByEmail(email)
      .orElseThrow(() -> new UsernameNotFoundException("Impossible de trouver l'utilisateur avec l'email : " + email));

    return tokenRepo.findByUser(usr)
      .orElseThrow(() -> new RuntimeException("Token introuvable pour l'utilisateur "+usr.getEmail()));
  }

  public String refreshAccessToken(String refreshToken){
    Token tokenEntity = tokenRepo.findByTokenValue(refreshToken)
      .orElseThrow(() -> new RuntimeException("Refresh token invalide"));
    
      if(tokenEntity.getExpiration().isBefore(Instant.now())){
        tokenRepo.delete(tokenEntity); //supprime le token expiré
        throw new RuntimeException("Refresh token expiré");

      }
      // on récupére l'utilisateur du token 
      User usr = tokenEntity.getUser();
      
      //Génére un nouvel access token
      UserDetails userDetails = customUserDetailsService.loadUserByUsername(usr.getEmail());
      
      return jwtService.generateRefreshToken(userDetails);

      
  }

  @Override
  public Token save(Token token) {
      return tokenRepo.save(token);
  }
  @Override
  public List<Token> getAll() {
    return tokenRepo.findAll();
  }
  @Override
  public Optional<Token> getById(UUID id) {
    return tokenRepo.findById(id);
  }
  @Override
  public void delete(UUID id) {
    Optional<Token> token = tokenRepo.findById(id);
    if(token.isPresent()){
      tokenRepo.delete(token.get());
    }
  }

}
