package com.example.EDLB.mappers.security;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.EDLB.factory.UserFactory;
import com.example.EDLB.models.entities.Role;
import com.example.EDLB.models.entities.User;
import com.example.EDLB.models.security.RegisterRequest;
import com.example.EDLB.repositories.JPA.RepositoryRole;
import com.example.EDLB.services.security.RegisterRequestService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class RegisterRequestMapper {
  private final ModelMapper modelMapper;
  private final RegisterRequestService serviceRegisterRequest;
  private final ObjectMapper objectMapper;
  private final PasswordEncoder passwordEncoder;
  private final RepositoryRole roleRepo;

  public User registerUserToUser (RegisterRequest register){
    List<Role> listDefaultRole = new ArrayList<Role>();// on créer une liste de role
    listDefaultRole.add(
      roleRepo.findByRoleName("New Register")
        .orElseThrow(
            () -> new RuntimeException("Role 'New Register' not found")
          )
        );
    register.setRoles(listDefaultRole);//on set le role par defaut au register 
    ObjectNode preferences = objectMapper.createObjectNode();
    //preferences par defaut
    preferences.put("notificationFollow", true);
    preferences.put("notificationMessage", true);
    preferences.put("darkTheme", false);
    preferences.put("notificationPublicity", true);
    preferences.put("notificationPublication", true);
    preferences.put("notificationFriend", true);
    /*
     * {"notificationFollow": true, "notificationMessage": false, "darkTheme": true, "notificationPublicity": false, "notificationPublication": true, "notificationFriend": true}
     */
    //TODO: gérer les role de propriétaire definis au registration
   // return modelMapper.map(register, User.class);
   return UserFactory.createRegisteredUser(register, passwordEncoder, listDefaultRole, preferences);
  }
  //TODO: Finir le mapper


}
