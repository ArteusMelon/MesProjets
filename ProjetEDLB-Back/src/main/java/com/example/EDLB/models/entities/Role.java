package com.example.EDLB.models.entities;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
@Table(name = "role")
public class Role {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="idrole")
    private UUID idRole;

    @Column(name="rolename", nullable = false)
    private String roleName;

    @Column(name="description")
    private String description;

    @ManyToMany(mappedBy = "roles")
    @JsonIgnoreProperties("roles")
    private List<User> users;

    public Role(String roleName, String description) {
        this.roleName = roleName;
        this.description = description;
    }
}
