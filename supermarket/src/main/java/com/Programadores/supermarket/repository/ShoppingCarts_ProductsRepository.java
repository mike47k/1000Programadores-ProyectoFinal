package com.Programadores.supermarket.repository;

import com.Programadores.supermarket.model.ShoppingCarts_Products;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface ShoppingCarts_ProductsRepository extends CrudRepository<ShoppingCarts_Products, Long> {

    Optional<ShoppingCarts_Products> findByShoppingCartIdAndProductId(Long cartId, Long productId);
    List<ShoppingCarts_Products> findByShoppingCartId(Long cartId);
}
