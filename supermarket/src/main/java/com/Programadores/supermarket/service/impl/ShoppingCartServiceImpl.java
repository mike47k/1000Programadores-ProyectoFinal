package com.Programadores.supermarket.service.impl;

import com.Programadores.supermarket.model.Product;
import com.Programadores.supermarket.model.ShoppingCart;
import com.Programadores.supermarket.model.ShoppingCarts_Products;
import com.Programadores.supermarket.repository.ProductRepository;
import com.Programadores.supermarket.repository.ShoppingCartRepository;
import com.Programadores.supermarket.repository.ShoppingCarts_ProductsRepository;
import com.Programadores.supermarket.service.ShoppingCartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ShoppingCartRepository shoppingCartJpaRepository;
    private final ProductRepository productJpaRepository;
    private final ShoppingCarts_ProductsRepository shoppingCarts_productsJpaRepository;

    @Override
    public ShoppingCart createShoppingCart(ShoppingCart entity) {
        return shoppingCartJpaRepository.save(entity);
    }

    @Override
    public ShoppingCart updateShoppingCart(Long id, ShoppingCart entity) {
        return null;
    }

    @Override
    public ShoppingCart getShoppingCartById(Long id) {
        return shoppingCartJpaRepository.findById(id).orElseThrow(()-> new RuntimeException());
    }

    @Override
    public ShoppingCart addProduct(Long ProductId, Long shoppingCart ,int amount) {
        ShoppingCart cart = shoppingCartJpaRepository.findById(shoppingCart).orElseThrow();
        Product product = productJpaRepository.findById(ProductId).orElseThrow();
        ShoppingCarts_Products cp = new ShoppingCarts_Products();
        cp.setProduct(product);
        cp.setShoppingCart(cart);
        cp.setAmount(amount);
        return shoppingCarts_productsJpaRepository.save(cp).getShoppingCart();
    }

    @Override
    public ShoppingCart removeProduct(Long ProductId, Long shoppingCart,int amount ,boolean delete) {
        if (delete){
        }
        return null;
    }
}
