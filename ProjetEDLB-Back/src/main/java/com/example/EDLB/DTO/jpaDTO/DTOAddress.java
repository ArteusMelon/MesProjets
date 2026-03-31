package com.example.EDLB.DTO.jpaDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DTOAddress {
    private String name;
    private String company;
    private String streetNumber;
    private String streetName;
    private String additionalInfo;
    private String postalCode;
    private String city;
    private String region;
    private String country;
    private Timestamp createdAt;
    private Timestamp updateAt;
}