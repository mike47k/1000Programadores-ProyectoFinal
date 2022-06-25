package com.Programadores.supermarket.repository;

import com.Programadores.supermarket.model.ShoppingCarts_Products;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ShoppingCarts_ProductsRepository extends PagingAndSortingRepository<ShoppingCarts_Products, Long> {
}
