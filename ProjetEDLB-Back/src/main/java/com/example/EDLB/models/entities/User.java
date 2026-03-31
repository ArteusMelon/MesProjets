package com.example.EDLB.models.entities;

import java.sql.Date;
//import java.util.ArrayList; //FIXME: Mettre tout en java.util.list
import java.util.List;
import java.util.UUID;
import com.example.EDLB.Enum.SexEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.annotations.Type;
import com.fasterxml.jackson.databind.JsonNode;
import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@RequiredArgsConstructor //Crér un constructeur avec uniquement les données obligatoires
@Builder
@Table(name = "\"user\"")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "\"iduser\"")
    private UUID idUser;

    @Column(name = "\"name\"", nullable = false)
    private String name;

    @Column(name = "\"firstname\"", nullable = false)
    private String firstname;

    @Column(name = "\"nickname\"", nullable = false)
    private String nickname;

    @JsonIgnore
    @Column(name = "\"password\"", nullable = false)
    private String password;

    @Column(name = "\"registrationdate\"", nullable = false)
    private Date registrationDate;

    @Column(name = "\"sex\"", nullable = false)
    @Enumerated(EnumType.STRING)
    @ColumnTransformer(write = "?::SEX_ENUM")
    private SexEnum sex;

    @Column(name = "\"birthdate\"")
    private Date birthDate;
    /**
     * TODO intérêt à vérifier
     * A priori : token de validation d'email -> si  c'est le cas nom à change en "user_validation_token"
     */
    
    @Column(name = "\"biography\"")
    private String biography;

    @Column(name = "\"updatedate\"")
    private Date updateDate;

    @Column(name = "\"email\"", nullable = false)
    private String email;

    @Column(name = "\"phonenumber\"")
    private String phoneNumber;

    @Type(JsonType.class)
    @Column(name = "\"preference_user\"", nullable = false,columnDefinition = "jsonb")
    private JsonNode preference;

    @OneToMany(mappedBy = "user")
    @JsonIgnoreProperties("user")
    private List<Dog> dogs;

    @OneToMany(mappedBy = "user")
    @JsonIgnoreProperties("user")
    private List<Order> orders;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("user")
    private List<Address> addresses;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "iduser"), inverseJoinColumns = @JoinColumn(name = "idrole"))
    @JsonIgnoreProperties("users")
    private List<Role> roles; //FIXME: il y avait un newarraytList qu iest supprimé maintenant a voir les problemes

    // public User(SexEnum sex, String name, String firstname, String nickname, String password, String biography, String email, String phoneNumber) {
    //     this.name = name;
    //     this.firstname = firstname;
    //     this.nickname = nickname;
    //     this.password = password;
    //     this.registrationDate = new Date();
    //     this.biography = biography;
    //     this.email = email;
    //     this.phoneNumber = phoneNumber;
    //     this.sex = sex;
    // }

    // public Object orElseThrow(Object object) {
    //     return null;
    // }
    //Ancienne methode d'Ugo (ca pète le SPR)
    // @Override
    // public Collection<? extends GrantedAuthority> getAuthorities() {
    //     List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();

    //     for (Role role : roles) {
    //         list.add(new SimpleGrantedAuthority("ROLE_"+ role));
    //     }
    //     return list;
    // }

    // @Override
    // public String getUsername() {
    //     return email;
    // }
}