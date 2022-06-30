package com.Programadores.supermarket.service;

import com.Programadores.supermarket.model.ShoppingCart;

public interface ShoppingCartService {
    ShoppingCart createShoppingCart(ShoppingCart entity);
    ShoppingCart updateShoppingCart(Long id, ShoppingCart entity);
    ShoppingCart getShoppingCartById(Long id);

    ShoppingCart getActiveCart(Long userId);
    ShoppingCart addProduct(Long ProductId,Long shoppingCart,int amount);
    void removeProduct(Long ProductId,Long shoppingCart);
}
