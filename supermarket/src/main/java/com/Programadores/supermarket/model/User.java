package com.Programadores.supermarket.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long id;
    private String name;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private Long dni;
    private String address;
    private String postalCode;

    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "role_id", referencedColumnName = "role_id", nullable = false)
    private Role role;
    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "card_id", referencedColumnName = "card_id", nullable = false)
    @ToString.Exclude
    private Card card;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<ShoppingCart> shoppingCarts ;



}
