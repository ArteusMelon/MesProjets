package com.example.EDLB.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "deliverymode")
public class DeliveryMode {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "iddeliverymode")
    private UUID idDeliveryMode;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private Double price;

    public DeliveryMode(String deliveryMode, String description, Double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
