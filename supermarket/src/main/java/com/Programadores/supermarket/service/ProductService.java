package com.Programadores.supermarket.service;

import com.Programadores.supermarket.model.Product;
import com.Programadores.supermarket.model.ProductList;
import org.springframework.data.domain.PageRequest;

public interface ProductService {

    Product createProduct(Product entity);
    void updateProduct(Long id,Product entity);
    ProductList listPorducts(PageRequest pageRequest);
    void deleteById(Long id);
}
