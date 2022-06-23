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
@Table(name = "shoppingCart")
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shoppingCart_id")
    private long id;
    private double total;
    private int discount;

    @ManyToMany(mappedBy = "shoppingCarts")
    private List<Product> products;

}
