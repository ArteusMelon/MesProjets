package com.example.EDLB.DTO.jpaDTO;

import com.example.EDLB.Enum.SexEnum;
import com.example.EDLB.models.entities.Litter;
import com.example.EDLB.models.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DTODog {
    private String name;
    private String numberLOF;
    private String numberICAD;
    private BigDecimal weight;
    private String dogCode;
    private Date birthdate;
    private Date modificationDate;
    private SexEnum sex;
    private String collarColor;
    private Litter litter;
    private User user;
}
