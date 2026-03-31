package com.example.EDLB.models.security;

import java.time.Instant;
import java.util.UUID;

import com.example.EDLB.Enum.TokenName;
import com.example.EDLB.models.entities.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "token")
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "idtoken", nullable = false)
    private UUID idToken;

    @Enumerated(EnumType.STRING)
    @Column(name = "tokenname", nullable = false)
    private TokenName tokenName;

    @Column(name = "tokenvalue", nullable = false)
    private String tokenValue;
    
    @Column(name = "tokenrevoked")
    private Boolean tokenRevoked;

    @Column(name = "expiration", nullable = false, columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private Instant expiration;

    @Column(name = "createdat", nullable = false, columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private Instant createdAt;

    @Column(name = "ip")
    private String ip;
    
    @ManyToOne
    @JoinColumn(name = "iduser")
    @JsonIgnoreProperties("tokens")
    private User user;

    
}
