package com.example.EDLB.models.entities;

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
@Table(name = "product_media")
public class ProductMedia {
    @EmbeddedId
    private ProductMediaId productMediaId;
    @ManyToOne
    @MapsId("idProduct")
    @JoinColumn(name = "idproduct", nullable = false)
    private Product product;

    @Column(name = "idmedia", insertable = false, updatable = false, nullable = false)
    private String idMedia;

    public ProductMedia(Product product, String idMedia) {
        this.productMediaId = new ProductMediaId(product.getIdProduct(), idMedia);
        this.product = product;
        }

}
