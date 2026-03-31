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
@Table(name = "litter_media")
public class LitterMedia {
    @EmbeddedId
    private LitterMediaId litterMediaId;
    @ManyToOne
    @MapsId("idLitter")
    @JoinColumn(name = "idlitter", nullable = false)
    private Litter litter;

    @Column(name = "idmedia", insertable = false, updatable = false, nullable = false)
    private String idMedia;

    public LitterMedia(Litter litter, String idMedia) {
        this.litterMediaId = new LitterMediaId(litter.getIdLitter(), idMedia);
        this.litter = litter;
    }

}
