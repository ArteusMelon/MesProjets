package com.example.EDLB.models.entities;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.UUID;

import com.example.EDLB.Enum.SexEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "dog")
public class Dog {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "iddog")
    private UUID idDog;

    @Column(name = "name")
    private String name;

    @Column(name = "numberlof")
    private String numberLOF;

    @Column(name = "numbericad")
    private String numberICAD;

    @Column(name = "weight")
    private BigDecimal weight;

    @Column(name = "dogcode")
    private String dogCode;

    @Column(name = "birthdate")
    private Date birthdate;

    @Column(name = "modificationdate")
    private Date modificationDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "sex")
    private SexEnum sex;

    @Column(name = "collarcolor")
    private String collarColor;

    @ManyToOne
    @JoinColumn(name = "idlitter")
    @JsonIgnoreProperties("dogs")
    private Litter litter;

    @ManyToOne
    @JoinColumn(name = "iduser")
    @JsonIgnoreProperties("dogs")
    private User user;

    public Dog(String name, String numberLOF, String numberICAD, BigDecimal weight, String dogCode, Date birthdate,
            Date modificationDate, SexEnum sex, Litter litter, User user) {
        this.name = name;
        this.numberLOF = numberLOF;
        this.numberICAD = numberICAD;
        this.weight = weight;
        this.dogCode = dogCode;
        this.birthdate = birthdate;
        this.modificationDate = modificationDate;
        this.sex = sex;
        this.litter = litter;
        this.user = user;
    }
}
