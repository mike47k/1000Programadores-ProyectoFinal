package com.Programadores.supermarket.repository;

import com.Programadores.supermarket.model.Product;
import com.Programadores.supermarket.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product,Long> {

}
