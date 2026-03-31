package com.example.EDLB.models.entities;

import java.sql.Date;
import java.util.List;
import java.util.UUID;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Table(name = "\"order\"")
public class Order {

    // public enum Status {
    //     En_Cours, Paiement_Refuse, Paiement_Accepte
    // }

    // public enum DeliveryMode {
    //     Livraison_Rapide, Livraison_Normale
    // }

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "idorder")
    private UUID idOrder;

    // @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "tracking")
    private String tracking;

    @Column(name = "ordernumber", nullable = false)
    private String orderNumber;

    @Column(name = "dateorder", nullable = false)
    private Date dateOrder;

    @OneToOne(mappedBy = "order")
    @JsonIgnoreProperties("order")
    private Payment payment;

    @ManyToOne
    @JoinColumn (name = "iddeliverymode")
    private DeliveryMode deliveryMode;

    @ManyToMany
    @JoinTable(
        name = "order_product",
        joinColumns = @JoinColumn(name = "idorder"),
        inverseJoinColumns = @JoinColumn(name = "idproduct"))
    @JsonIgnoreProperties("orders")
    private List<Product> products;

    @ManyToOne
    @JoinColumn(name="iduser", nullable = false)
    @JsonIgnoreProperties("orders")
    private User user;

    @ManyToOne
    @JoinColumn(name="idaddress", nullable = false)
    @JsonIgnoreProperties("orders")
    private Address address;

    public Order(String status, String tracking, DeliveryMode deliveryMode, String orderNumber, Date dateOrder, Payment payment, List<Product> products, User user, Address address) {
        this.status = status;
        this.tracking = tracking;
        this.deliveryMode = deliveryMode;
        this.orderNumber = orderNumber;
        this.dateOrder = dateOrder;
        this.payment = payment;
        this.products = products;
        this.user = user;
        this.address = address;
    }
}