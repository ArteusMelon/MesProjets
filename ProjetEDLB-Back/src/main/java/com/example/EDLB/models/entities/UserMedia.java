package com.example.EDLB.models.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_media")
public class UserMedia {
    
    @EmbeddedId
    private UserMediaId userMediaId;
    @ManyToOne
    @MapsId("idUser")
    @JoinColumn(name = "iduser", nullable = false)
    private User user;

    @Column(name = "idmedia", insertable = false, updatable = false, nullable = false)
    private String idMedia;

    public UserMedia(User user, String idMedia) {
        this.userMediaId = new UserMediaId(user.getIdUser(), idMedia);
        this.user = user;
    }
}
