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
public class UserRelationId implements Serializable {
    @Column(name="iduserreceiver")
    private UUID idUserReceiver;
    @Column(name="idsourceuser")
    private UUID idSourceUser;
    @Column(name="idrelationtype")
    private UUID idRelationType;
}