package com.example.EDLB.models.entities;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table(name = "litter")
public class Litter {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "idlitter")
    private UUID idLitter;
    @Column(name = "numberlof")
    private String numberLOF;
    @Column(name = "numberlitter")
    private String numberLitter;
    @Column(name = "matingdate", nullable = false)
    private Date matingDate;
    @Column(name = "birthdate")
    private Date birthDate;
    @OneToMany(mappedBy = "litter")
    @JsonIgnoreProperties("litter")
    private List<Dog> dogs;

    public Litter(String numberLOF, String numberLitter, Date matingDate, Date birthDate, List<Dog> dogs) {
        this.numberLOF = numberLOF;
        this.numberLitter = numberLitter;
        this.matingDate = matingDate;
        this.birthDate = birthDate;
        this.dogs = dogs;
    }
}