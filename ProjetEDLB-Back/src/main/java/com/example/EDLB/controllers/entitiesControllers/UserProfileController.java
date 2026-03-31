package com.example.EDLB.controllers.entitiesControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EDLB.DTO.jpaDTO.UserProfileDTO;
import com.example.EDLB.mappers.MapperUserProfile;
import com.example.EDLB.models.entities.User;
import com.example.EDLB.models.security.CustomUserDetails;
import com.example.EDLB.services.postgre.ServiceUser;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/profile")
@AllArgsConstructor
public class UserProfileController {

   
    private ServiceUser serviceUser;
    private final MapperUserProfile usrMapper;

  
    @GetMapping
    public UserProfileDTO getProfileDTO(@AuthenticationPrincipal CustomUserDetails userDetails) {

        User usr = serviceUser.findByEmail(userDetails.getUsername());
        return usrMapper.userToProfileMapper(usr);
//TODO: Regardez tous MA TOUTE PUISSANCE O.O
    }
}
