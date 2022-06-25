package com.Programadores.supermarket.service;

import com.Programadores.supermarket.model.Product;
import com.Programadores.supermarket.model.ProductList;
import com.Programadores.supermarket.model.ShoppingCart;
import org.springframework.data.domain.PageRequest;

public interface ShoppingCartService {
    ShoppingCart createShoppingCart(ShoppingCart entity);
    ShoppingCart updateShoppingCart(Long id, ShoppingCart entity);
    ShoppingCart getShoppingCartById(Long id);
    ShoppingCart addProduct(Long ProductId,Long shoppingCart,int amount);
    ShoppingCart removeProduct(Long ProductId,Long shoppingCart,int amount,boolean delete);
}
