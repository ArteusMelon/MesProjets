// package com.example.EDLB.services.old;

// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.AuthenticationException;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.stereotype.Service;
// import com.example.EDLB.DTO.authDTO.LoginUserDto;
// import com.example.EDLB.DTO.authDTO.RegisterUserDto;
// import com.example.EDLB.models.entities.User;
// import com.example.EDLB.repositories.JPA.RepositoryUser;

// @Service
// public class AuthenticationService {

//     private final RepositoryUser userRepository;
//     private final PasswordEncoder passwordEncoder;
//     private final AuthenticationManager authenticationManager;
//     private final UserDetailsService userDetailsService;

//     public AuthenticationService(
//             RepositoryUser userRepository,
//             AuthenticationManager authenticationManager,
//             PasswordEncoder passwordEncoder,
//             UserDetailsService userDetailsService) {
//         this.authenticationManager = authenticationManager;
//         this.userRepository = userRepository;
//         this.passwordEncoder = passwordEncoder;
//         this.userDetailsService = userDetailsService;
//     }

//     // Méthode pour enregistrer un utilisateur
//     public User registerUser(RegisterUserDto input) throws IllegalArgumentException {
//         // Vérifie si l'email existe déjà
//         if (userRepository.existsByEmail(input.email())) {
//             throw new IllegalArgumentException("Email déja utilisé");
//         }

//         // Crée un nouvel utilisateur
//         User user = new User();
//         user.setFirstname(input.firstname());
//         user.setName(input.name());
//         user.setNickname(input.nickname());
//         user.setRegistrationDate(input.registrationDate());
//         user.setPreference(input.preference());
//         user.setEmail(input.email());
//         user.setPassword(passwordEncoder.encode(input.password())); // Hashage du mot de passe
//         user.setSex(input.sex());

//         return userRepository.save(user);
//     }

//     // Méthode pour authentifier un utilisateur
//     public User authenticateUser(LoginUserDto input) {
//         try {
//             // Authentifier l'utilisateur via AuthenticationManager
//             Authentication authentication = authenticationManager.authenticate(
//                     new UsernamePasswordAuthenticationToken(input.email(), input.password()));

//             // Mettre l'authentification dans le contexte
//             SecurityContextHolder.getContext().setAuthentication(authentication);

//             // Récupérer les informations utilisateur de la base de données
//             return userRepository.findByEmail(input.email())
//                     .orElseThrow(() -> new UsernameNotFoundException("User not found"));

//         } catch (AuthenticationException e) {
//             // Gestion des erreurs d'authentification (mauvais mot de passe, etc.)
//             throw new IllegalArgumentException("Invalid username or password", e);
//         }
//     }
// }
