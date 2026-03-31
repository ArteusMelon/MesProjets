package com.example.EDLB.services.security;


import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.EDLB.mappers.security.RegisterRequestMapper;
import com.example.EDLB.models.entities.User;
import com.example.EDLB.models.security.AuthenticationRequest;
import com.example.EDLB.models.security.AuthenticationResponse;
import com.example.EDLB.models.security.CustomUserDetails;
import com.example.EDLB.models.security.RegisterRequest;
import com.example.EDLB.models.security.RegisterResponse;
import com.example.EDLB.models.security.Token;
import com.example.EDLB.repositories.JPA.RepositoryUser;
import com.example.EDLB.repositories.JPA.Security.TokenRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
  private final RepositoryUser userRepo;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;
  private final CustomUserDetailsService customUserDetailsService;
  private final RegisterRequestMapper registerMapper;
  private final TokenRepository tokenRepo;
  private final TokenService tokenService;

  public AuthenticationResponse authenticate(AuthenticationRequest request){
    //Voir le prof
    authenticationManager.authenticate(
      new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
    );
    //On cherche l'utilisateur dans la BDD
    User user = userRepo.findByEmail(request.getEmail())
      .orElseThrow(() -> new UsernameNotFoundException("Utilisateur non trouvé"));
      //Création du customUserDetails de spring security
    CustomUserDetails userDetails = new CustomUserDetails(user, customUserDetailsService.getAuthorities(user));
      //On génére les Tokens
    String accessJwtToken = jwtService.generateToken(userDetails);
    String refreshJwtToken = jwtService.generateRefreshToken(userDetails);  
    //On créer un token de BDD
    Token refreshToken = tokenService.createRefreshToken(refreshJwtToken, user);
    //On le sauvegarde dans la base
    tokenRepo.save(refreshToken);
    //On retourne un AuthentificationReponse
    return new AuthenticationResponse(accessJwtToken);
  }

  public void register(RegisterRequest request){
    //Vérifie di l'email est déjà utilisé
    if(userRepo.existsByEmail(request.getEmail())){
      throw new IllegalStateException("Email déjà utilisé !");
    }
    //Création d'un utilisateur
    User requestRegisterUser = registerMapper.registerUserToUser(request);
    //Sauvegarde en base 
    userRepo.save(requestRegisterUser);
    //On set les authorisations
    // List<SimpleGrantedAuthority> authority = new ArrayList<>();
    // authority.add(new SimpleGrantedAuthority("New Register"));
    // //Génération du token
    // String jwtToken = jwtService.generateToken(new CustomUserDetails(registeredUser, authority));
    // return new RegisterResponse(jwtToken);
  }
}
