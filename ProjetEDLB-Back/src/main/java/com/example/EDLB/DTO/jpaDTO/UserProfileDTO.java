package com.example.EDLB.DTO.jpaDTO;

import java.sql.Date;
import java.util.List;

import com.example.EDLB.models.entities.Address;
import com.example.EDLB.models.entities.Dog;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Data
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class UserProfileDTO {
  private String name;
  private String firstname;
  private String biography;
  private String nickname;
  private String email;
  private List<Address> addresses;
  private String phoneNumber;
  private Date birthDate;
  private Date registrationDate;
  private List<Dog> dogs;
  
}
