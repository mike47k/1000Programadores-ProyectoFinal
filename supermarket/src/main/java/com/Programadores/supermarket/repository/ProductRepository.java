package com.Programadores.supermarket.repository;

import com.Programadores.supermarket.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepository extends PagingAndSortingRepository<Product,Long> {
}