package com.Programadores.supermarket.service;

import com.Programadores.supermarket.model.Pay;
import com.Programadores.supermarket.model.ShoppingCart;
import com.Programadores.supermarket.model.ShoppingCarts_Products;

import java.util.List;

public interface ShoppingCartService {
    ShoppingCart createShoppingCart(ShoppingCart entity);
    ShoppingCart updateShoppingCart(Long id, ShoppingCart entity);
    ShoppingCart getShoppingCartById(Long id);

    ShoppingCart getActiveCart(Long userId);

    ShoppingCart getCart(Long cartId);
    ShoppingCart addProduct(Long ProductId,Long shoppingCart,int amount);
    void removeProduct(Long ProductId,Long shoppingCart);
    Pay payCart(Long idUser, Long idCart);
    List<ShoppingCarts_Products> getProducts(long id);
}
