package com.example.EDLB.services.security;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.example.EDLB.Enum.TokenName;
import com.example.EDLB.models.security.Token;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;

@Service
public class JwtService {
  //TODO: Changer l'emplacement de la KEY
  private static final String SECRET_KEY = "ma_super_mega_clé_secrete_de_fou";
  //CAUTION: getUsername de UserDetailsService et extract username font reference a l'email 

  public byte[] getByteKey(String key){
    return SECRET_KEY.getBytes();
  }

  public String extractUsername(String token){
    return extractClaim(token, Claims::getSubject); // les :: représente une lambda cela prends la variable de la lambda et exerce la methode de reference (ternaire lambda ? en grossomodo)
    //Exemple1 = noms.forEach(e -> e.getUsername()); || noms.forEach(User::getUsername);
    //Exemple2 = noms.forEach(e -> String.toUpperCase(e)); || noms.forEach(String::toUpperCase);
  }

  /**
   * Permet de faire n'importe quelle appelle de methode des types CLaims plus simplement
   * exemple: extractClaim(token, Claims::EXPIRATION)
   * 
   * @param <T> 
   * @param token votre token
   * @param claimsResolver Claims::getSubject ou autres
   * @return Retourne un claim demandé via d'apelle de methode dans les parametres
   */
  public <T> T extractClaim(String token, Function<Claims, T> claimsResolver){
    Claims claims = extractAllClaims(token);
    return claimsResolver.apply(claims);
  }

  private Claims extractAllClaims(String token){
    return Jwts.parserBuilder() //Nouvelle synthaxe
            .setSigningKey(getByteKey(SECRET_KEY))//Nouvelle methode (transformer la clé en byte avant de le mettre dans crypter le token)
            .build()
            .parseClaimsJws(token)
            .getBody();
  }

  public String generateToken(UserDetails userdetails){
    Instant now = Instant.now();
    Instant expiration = now.plus(1, ChronoUnit.HOURS);

    return Jwts.builder()
              .setSubject(userdetails.getUsername())
              .setIssuedAt(Date.from(now))
              .setExpiration(Date.from(expiration)) // 1 heure
              .signWith(Keys.hmacShaKeyFor(getByteKey(SECRET_KEY)))// AlgoSignature deprecated, donc on Créer une Key hmacShaker pour la clé qui est byté
              .compact();
  }

  public String generateRefreshToken(UserDetails userdetails){
    Instant now = Instant.now();
    Instant expiration = now.plus(7, ChronoUnit.DAYS);

    return Jwts.builder()
              .setSubject(userdetails.getUsername())
              .setIssuedAt(Date.from(now))
              .setExpiration(Date.from(expiration)) // 7 jours
              .signWith(Keys.hmacShaKeyFor(getByteKey(SECRET_KEY)))// AlgoSignature deprecated, donc on Créer une Key hmacShaker pour la clé qui est byté
              .compact();

  }

  public boolean isTokenValid(String token, UserDetails userDetails){
    String userName = extractUsername(token);
    return userName.equals(userDetails.getUsername()) && !isTokenExpired(token);
  }

  private boolean isTokenExpired(String token){
    return extractClaim(token, Claims::getExpiration).toInstant().isBefore(Instant.now());
  }


}
