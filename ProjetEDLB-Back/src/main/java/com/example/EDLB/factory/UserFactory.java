package com.example.EDLB.factory;


import java.sql.Date;
import java.util.List;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.example.EDLB.models.entities.Role;
import com.example.EDLB.models.entities.User;
import com.example.EDLB.models.security.RegisterRequest;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserFactory {
  
  public static User createRegisteredUser(RegisterRequest request, PasswordEncoder passwordEncoder, List<Role> roles, JsonNode preferences){

    return User.builder()
            .name(request.getName())
            .firstname(request.getFirstname())
            .nickname(request.getNickname())
            .password(passwordEncoder.encode(request.getPassword()))
            .registrationDate(new Date(System.currentTimeMillis()))
            .sex(request.getSex())
            .email(request.getEmail())
            .preference(preferences)
            .roles(roles)
            .build();
  }
}
