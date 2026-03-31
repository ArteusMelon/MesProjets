package com.example.EDLB.models.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="user_relation")
public class UserRelation {

    @EmbeddedId
    private UserRelationId userRelationId;

    @ManyToOne
    @MapsId("idUserReceiver")
    @JoinColumn(name = "iduserreceiver", nullable = false)
    private User userReceiver;

    @ManyToOne
    @MapsId("idSourceUser")
    @JoinColumn(name = "idsourceuser", nullable = false)
    private User sourceUser;

    @ManyToOne
    @MapsId("idRelationType")
    @JoinColumn(name = "idrelationtype", nullable = false)
    private RelationType relationType;

    public UserRelation(User userReceiver, User sourceUser, RelationType relationType) {
        this.userRelationId = new UserRelationId(userReceiver.getIdUser(), sourceUser.getIdUser(), relationType.getIdRelationType());
        this.userReceiver = userReceiver;
        this.sourceUser = sourceUser;
        this.relationType = relationType;
    }
}
