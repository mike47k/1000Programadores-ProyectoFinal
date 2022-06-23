package com.Programadores.supermarket.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "pay")
public class Pay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pay_id")
    private long id;
    private double total;
    private String address;

    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "shoppingCart_id", referencedColumnName = "shoppingCart_id", nullable = false)
    private ShoppingCart shoppingCart;

}
