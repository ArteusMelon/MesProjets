package com.example.EDLB.models.security;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.EDLB.Enum.SexEnum;
import com.example.EDLB.models.entities.Role;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class RegisterRequest {

    private String name;
    private String firstname;
    private String nickname;
    private String password;
    private Date registrationDate;
    private SexEnum sex;
    private String email;
    private JsonNode preference;
    private List<Role> roles = new ArrayList<>();
}