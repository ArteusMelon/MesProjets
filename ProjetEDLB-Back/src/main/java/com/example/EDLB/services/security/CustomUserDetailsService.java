package com.example.EDLB.services.security;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.example.EDLB.models.entities.User;
import com.example.EDLB.models.security.CustomUserDetails;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.EDLB.repositories.JPA.RepositoryUser;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor //Génére automatiquement le constructeur de la classe grâce Lombok (les champs final)
public class CustomUserDetailsService implements UserDetailsService{
  
  private final RepositoryUser userRepository; //Injection automatique grace a RequiredArgsConstructor (plus besoin de @AutoWired qui est une mauvaise pratique)

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    //On récupére l'utilisateur grace a l'email
    User user = userRepository.findByEmail(email)
      .orElseThrow(() -> new UsernameNotFoundException("Utilisateur non trouvé avec l'email"  + email));
    
    //On retourne un objet UserDetails (Spring Security)
    return new CustomUserDetails(user, getAuthorities(user));
    // return new org.springframework.security.core.userdetails.User(
    //   user.getEmail(),
    //   user.getPassword(),
    //   getAuthorities(user)
    // ); //Le map renvoie une list
  }

  public List<SimpleGrantedAuthority> getAuthorities(User user){
    return user.getRoles().stream() //On stream tout les rôles 
        .map(role -> new SimpleGrantedAuthority(role.getRoleName())) //On convertis chaque role en authorité spring secu
        .collect(Collectors.toList());//List mutable
  }

      /**
     * Fonction permettant de recupérer le UserDetails current
     * @return un CurrentUserDetails
     */
    public CustomUserDetails getCurrentUser(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof CustomUserDetails){
            return (CustomUserDetails) principal; //On recupére le nom de l'utilisateur connecté
        }else{
            throw new RuntimeException("Utilisateur non trouvé");
        }
    }

}
