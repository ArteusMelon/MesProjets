package com.example.EDLB.models.entities;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="relation_type")
public class RelationType {
    @Id
    @Column(name = "idrelationtype")
    private UUID idRelationType;

    @Column(name = "relationname", nullable = false)
    private String relationName;

    @Column(name = "description")
    private String description;


    public RelationType(String relationName, String description) {
        this.relationName = relationName;
        this.description = description;
    }
}
