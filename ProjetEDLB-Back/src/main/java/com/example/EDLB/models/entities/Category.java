package com.example.EDLB.models.entities;

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
@Table(name = "category")

public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="idcategory")
    private UUID idCategory;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="description")
    private String description;

    @ManyToMany
    @JoinTable(
        name = "product_category",
        joinColumns = @JoinColumn(name = "idcategory"),
        inverseJoinColumns = @JoinColumn(name = "idproduct")
    )
    @JsonIgnoreProperties("categories")
    private List<Product> products;
    
    public Category(String name, String description) {
        this.name=name;
        this.description=description;
    }
}