package com.example.EDLB.DTO.jpaDTO;

import com.example.EDLB.models.entities.Dog;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DTOLitter {
    private String NumberLOF;
    private String NumberICAD;
    private String NumberLitter;
    private Date matingDate;
    private Date birthDate;
    private List<Dog> dogs;
}