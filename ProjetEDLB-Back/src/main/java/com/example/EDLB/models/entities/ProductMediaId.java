package com.example.EDLB.models.entities;

import java.io.Serializable;
import java.util.UUID;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class ProductMediaId implements Serializable {
    @Column(name = "idproduct")
    private UUID idProduct;
    @Column(name = "idmedia")
    private String idMedia;

}
