package com.Programadores.supermarket.repository;

import com.Programadores.supermarket.model.ShoppingCart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ShoppingCartRepository extends CrudRepository<ShoppingCart,Long> {
    ShoppingCart findByIsActiveAndUserId(Boolean is_active,Long id);

}
