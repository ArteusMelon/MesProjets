package com.example.EDLB.models.entities;

import java.sql.Date;
import java.util.UUID;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
@Table(name = "payment")

public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="idpayment")
    private UUID idPayment;

    @Column(name="type", nullable = false)
    private String type;

    @Column(name="paymentdate", nullable = false)
    private Date paymentDate;

    @OneToOne
    @JoinColumn(name="idorder", nullable = false)
    @JsonIgnoreProperties("payment")
    private Order order;

    public Payment(String type, Date paymentDate, Order order) {
        this.type = type;
        this.paymentDate = paymentDate;
        this.order = order;
    }
}

