package com.example.EDLB.services.postgre;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.EDLB.DTO.jpaDTO.DTOUser;
import com.example.EDLB.models.entities.Role;
import com.example.EDLB.models.entities.User;
import com.example.EDLB.repositories.JPA.RepositoryRole;
import com.example.EDLB.repositories.JPA.RepositoryUser;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ServiceUser implements IServicePostgre<User> {

    @Autowired
    PasswordEncoder passwordEncoder;
    
    @Autowired
    private RepositoryUser userRepository;

    @Autowired
    private RepositoryRole roleRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getById(UUID userId) {
        return userRepository.findById(userId);
    }

    @Override
    public void delete(UUID userId) {
        Optional<User> user = getById(userId);
        if (user.isPresent()) {
            userRepository.delete(user.get());
        }
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    public User addUser(DTOUser dtoUser) {
        if (dtoUser == null) {
            throw new IllegalArgumentException("Missing fields. Can't create a new user without user's informations.");
        }
        if (dtoUser.getName().isBlank() || dtoUser.getFirstname().isBlank() || dtoUser.getNickname().isBlank() || dtoUser.getPassword().isBlank() || dtoUser.getEmail().isBlank() || dtoUser.getSex()!=null) {
            throw new IllegalArgumentException("Missing fields. Name, firstname, nickname, password, email and sex are required.");
        }

        Role role = roleRepository.findByRoleName("User")
                .orElseThrow(() -> new RuntimeException("Role 'User' not found"));
        dtoUser.getRoles().add(role);
        User user = new User();
        user.setName(dtoUser.getName());
        user.setFirstname(dtoUser.getFirstname());
        user.setNickname(dtoUser.getNickname());
        user.setPassword(dtoUser.getPassword());
        user.setRegistrationDate(dtoUser.getRegistrationDate());
        user.setSex(dtoUser.getSex());
        user.setBirthDate(dtoUser.getBirthDate());
        user.setBiography(dtoUser.getBiography());
        user.setEmail(dtoUser.getEmail());
        user.setPhoneNumber(dtoUser.getPhoneNumber());
        return save(user);
    }

    public User updateUser(UUID id, DTOUser dtoUser){

        //.map ne s'executant que lorsque l'Optional contient une valeur, nul besoin de tester l'optional avec .isPresent au préalable.
        return getById(id).map(existingUser -> {

            if(!dtoUser.getName().isBlank() && !dtoUser.getName().equals(existingUser.getName())){existingUser.setName(dtoUser.getName());}
            if(!dtoUser.getFirstname().isBlank() && !dtoUser.getFirstname().equals(existingUser.getFirstname())){existingUser.setFirstname(dtoUser.getFirstname());}
            if(!dtoUser.getNickname().isBlank() && !dtoUser.getNickname().equals(existingUser.getNickname())){existingUser.setNickname(dtoUser.getNickname());}
            if(!dtoUser.getPassword().isBlank() && !dtoUser.getPassword().equals(existingUser.getPassword())){existingUser.setPassword(passwordEncoder.encode(dtoUser.getPassword()));}  // -> dto.getPassword().ifPresent(pwd -> existingUser.setPassword(hashPassword(pwd)));
            if(dtoUser.getSex()!=null && !dtoUser.getSex().equals(existingUser.getSex())){existingUser.setSex(dtoUser.getSex());}
            if(dtoUser.getBirthDate()!=null && !dtoUser.getBirthDate().equals(existingUser.getBirthDate())){existingUser.setBirthDate(dtoUser.getBirthDate());}
            if(!dtoUser.getBiography().isBlank() && !dtoUser.getBiography().equals(existingUser.getBiography())){existingUser.setBiography(dtoUser.getBiography());}
            if(dtoUser.getUpdateDate()!=null){existingUser.setUpdateDate(dtoUser.getUpdateDate());}
            if(!dtoUser.getEmail().isBlank() && !dtoUser.getEmail().equals(existingUser.getEmail())){existingUser.setEmail(dtoUser.getEmail());}
            if(dtoUser.getPreference()!=null && !dtoUser.getPreference().equals(existingUser.getPreference())){existingUser.setPreference(dtoUser.getPreference());}
            if(dtoUser.getAddresses()!=null && !dtoUser.getAddresses().equals(existingUser.getAddresses())){existingUser.setAddresses(dtoUser.getAddresses());}
            if(dtoUser.getRoles()!=null && !dtoUser.getRoles().equals(existingUser.getRoles())){existingUser.setRoles(dtoUser.getRoles());}

            return save(existingUser);
        }).orElseThrow(() -> new EntityNotFoundException("ID User : "+id+" not found."));
    }

    /**
     * Fonction permettant de recupérer le nom de l'utilisateur courant (connecté)
     * @return son adresse email
     */
    public String getCurrentUsername(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof UserDetails){
            return ((UserDetails) principal).getUsername(); //On recupére le nom de l'utilisateur connecté
        }else{
            return principal.toString();
        }
    }

    public boolean existsByEmail(String email){
        return userRepository.existsByEmail(email);
    }

    public User findByEmail(String email){
        return userRepository.findByEmail(email)
            .orElseThrow(() -> new UsernameNotFoundException("Impossible de trouvé l'utilisateur avec l'email : " + email));
    }
}