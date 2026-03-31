package com.example.EDLB.DTO.jpaDTO;

import java.sql.Date;
import java.util.List;
import com.example.EDLB.Enum.SexEnum;
import com.example.EDLB.models.entities.Address;
import com.example.EDLB.models.entities.Role;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DTOUser {
    private String name;
    private String firstname;
    private String nickname;
    private String password;
    private Date registrationDate;
    private SexEnum sex;
    private Date birthDate;
    private String biography;
    private Date updateDate;
    private String email;
    private JsonNode preference;
    private String phoneNumber;
    private List<Address> addresses;
    private List<Role> roles;
}
