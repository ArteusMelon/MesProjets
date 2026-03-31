package com.example.EDLB.DTO.jpaDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DTODeliveryMode {
    private String name;
    private String description;
    private Double price;
}