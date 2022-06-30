package com.Programadores.supermarket.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
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
    private boolean isActive;

    @JsonManagedReference
    @OneToMany(mappedBy = "shoppingCart", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<ShoppingCarts_Products> shoppingCarts_products ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user ;

}
