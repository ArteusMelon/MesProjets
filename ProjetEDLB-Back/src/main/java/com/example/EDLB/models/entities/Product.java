package com.example.EDLB.models.entities;

import java.math.BigDecimal;
import java.sql.Date;
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
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="idproduct")
    private UUID idProduct;
    @Column(name="name",nullable = false)
    private String name;
    @Column(name="price")
    private BigDecimal price;
    @Column(name="stock")
    private Integer stock;
    @Column(name="creationdate",nullable = false)
    private Date creationDate;
    @Column(name="releasedate")
    private Date releaseDate;
    @Column(name="display",nullable = false)
    private Boolean display;
    @Column(name="productdescription")
    private String productDescription;
    @Column(name="updatedate")
    private Date updateDate;

    @ManyToMany(mappedBy = "products")
    @JsonIgnoreProperties("products")
    private List<Order> orders;
    @ManyToMany(mappedBy = "products")
    @JsonIgnoreProperties("products")
    private List<Category> categories;

    public Product(String name, BigDecimal price, Integer stock, Date creationDate, Date releaseDate, Boolean display, String productDescription, Date updateDate) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.creationDate = creationDate;
        this.releaseDate = releaseDate;
        this.display = display;
        this.productDescription = productDescription;
        this.updateDate = updateDate;
    }
}
