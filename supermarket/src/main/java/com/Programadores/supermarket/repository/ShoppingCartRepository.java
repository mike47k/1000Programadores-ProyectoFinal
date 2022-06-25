package com.Programadores.supermarket.repository;

import com.Programadores.supermarket.model.ShoppingCart;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ShoppingCartRepository extends PagingAndSortingRepository<ShoppingCart,Long> {
}
