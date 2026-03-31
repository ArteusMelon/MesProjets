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
@Table(name = "dog_media")
public class DogMedia {

    @EmbeddedId
    private DogMediaId dogMediaId;
    @ManyToOne
    @MapsId("idDog")
    @JoinColumn(name = "iddog", nullable = false)
    private Dog dog;

    @Column(name = "idmedia", insertable = false, updatable = false, nullable = false)
    private String idMedia;

    public DogMedia(Dog dog, String idMedia) {
        this.dogMediaId = new DogMediaId(dog.getIdDog(), idMedia);
        this.dog = dog;
    }
}