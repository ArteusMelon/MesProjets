// package com.example.EDLB.services.old;

// import java.util.Date;
// import java.util.HashMap;
// import java.util.Map;
// import java.util.function.Function;

// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.stereotype.Service;

// import com.example.EDLB.models.entities.User;

// import io.jsonwebtoken.Claims;
// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.SignatureAlgorithm;
// import io.jsonwebtoken.io.Decoders;

// @Service
// public class JwtService {

//     @Value("${security.jwt.secret-key}")
//     private String secretKey; // Injection de la clé secrète via @Value
//     @Value("${security.jwt.expiration-time}")
//     private long jwtExpiration; // Durée d'expiration du token

//     // Extraire le nom d'utilisateur depuis le token
//     public String extractUsername(String token) {
//         return extractClaim(token, Claims::getSubject);
//     }

//     // Extraire une réclamation (claim) depuis le token
//     public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
//         final Claims claims = extractAllClaims(token);
//         return claimsResolver.apply(claims);
//     }

//     // Générer un token à partir des informations de l'utilisateur
//     public String generateToken(UserDetails userDetails) {
//         HashMap<String, Object> extraClaims = new HashMap<>();
//         extraClaims.put("id", ((User) userDetails).getUserId());
        
//         return generateToken(extraClaims, userDetails); // Appel à la méthode avec un Map vide pour les extra claims
//     }

//     // Générer un token avec des informations supplémentaires (extra claims)
//     public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {
//         return buildToken(extraClaims, userDetails, jwtExpiration);
//     }

//     // Retourner le temps d'expiration du token
//     public long getExpirationTime() {
//         return jwtExpiration;
//     }

//     // Construire le token avec les claims, sujet, date d'expiration et signature
//     private String buildToken(Map<String, Object> extraClaims, UserDetails userDetails, long expiration) {
//         return Jwts.builder()
//                 .setClaims(extraClaims)
//                 .setSubject(userDetails.getUsername())
//                 .setIssuedAt(new Date(System.currentTimeMillis()))
//                 .setExpiration(new Date(System.currentTimeMillis() + expiration))
//                 .signWith(SignatureAlgorithm.HS256, getSignInKey())
//                 .compact();
//     }

//     // Vérifier si le token est valide
//     public boolean isTokenValid(String token, UserDetails userDetails) {
//         final String username = extractUsername(token);
//         return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
//     }

//     // Vérifier si le token est expiré
//     private boolean isTokenExpired(String token) {
//         return extractExpiration(token).before(new Date());
//     }

//     // Extraire la date d'expiration du token
//     private Date extractExpiration(String token) {
//         return extractClaim(token, Claims::getExpiration);
//     }

//     // Extraire toutes les informations des claims à partir du token
//     private Claims extractAllClaims(String token) {
//         return Jwts.parserBuilder()
//                 .setSigningKey(getSignInKey())
//                 .build()
//                 .parseClaimsJws(token)
//                 .getBody();
//     }

//     // Extraire la clé secrète sous forme de byte[] pour la signature
//     private byte[] getSignInKey() {
//         return Decoders.BASE64.decode(secretKey); // Décoder la clé secrète en Base64
//     }
// }
