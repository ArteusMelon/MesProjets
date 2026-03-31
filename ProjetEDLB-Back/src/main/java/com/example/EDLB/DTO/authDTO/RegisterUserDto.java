package com.example.EDLB.DTO.authDTO;

import java.sql.Date;
import com.example.EDLB.Enum.SexEnum;
import com.fasterxml.jackson.databind.JsonNode;

public record RegisterUserDto(String name, String nickname, Date registrationDate, String email, String password,
        String firstname, JsonNode preference, SexEnum sex) {
}
