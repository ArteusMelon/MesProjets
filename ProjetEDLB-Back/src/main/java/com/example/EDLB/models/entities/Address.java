package com.example.EDLB.models.entities;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="\"address\"")
public class Address {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "\"idaddress\"")
    private UUID idAddress;
    @Column(name = "\"name\"")
    private String name;
    @Column(name = "\"company\"")
    private String company;
    @Column(name = "\"streetnumber\"")
    private String streetNumber;
    @Column(name = "\"streetname\"", nullable = false)
    private String streetName;
    @Column(name = "\"additionalinfo\"")
    private String additionalInfo;
    @Column(name = "\"postalcode\"", nullable = false)
    private String postalCode;
    @Column(name = "\"city\"", nullable = false)
    private String city;
    @Column(name = "\"region\"")
    private String region;
    @Column(name = "\"country\"", nullable = false)
    private String country;
    @Column(name = "\"createdat\"")
    private Timestamp createdAt;
    @Column(name = "\"updatedat\"")
    private Timestamp updatedAt;
    
    @OneToMany(mappedBy = "address")
    @JsonIgnoreProperties("address")
    private List<Order> orders;

    @ManyToOne
    @JoinColumn(name = "iduser", nullable = false)
    private User user;

    public Address(String name, String company, String streetNumber, String streetName, String additionalInfo, String postCode, String city, String region, String country) {
        this.name = name;
        this.company = company;
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.additionalInfo = additionalInfo;
        this.postalCode = postCode;
        this.city = city;
        this.region = region;
        this.country = country;
        this.createdAt = Timestamp.valueOf(LocalDateTime.now());
    }
}