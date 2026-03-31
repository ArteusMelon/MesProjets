package com.example.EDLB.mappers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.EDLB.DTO.jpaDTO.UserProfileDTO;
import com.example.EDLB.models.entities.Dog;
import com.example.EDLB.models.entities.User;
import com.example.EDLB.services.postgre.ServiceDog;
import com.example.EDLB.services.postgre.ServiceUser;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MapperUserProfile {

  private final ModelMapper modelMapper;
  private final ServiceUser usrService;


  public UserProfileDTO userToProfileMapper(User usrToMap){

    User usr = usrService.getById(usrToMap.getIdUser())
      .orElseThrow(() -> new UsernameNotFoundException("Impossible de trouver l'utilisateur "+usrToMap.getNickname()+ " pour le profile"));


    return modelMapper.map(usrToMap, UserProfileDTO.class);

    

  }


}
