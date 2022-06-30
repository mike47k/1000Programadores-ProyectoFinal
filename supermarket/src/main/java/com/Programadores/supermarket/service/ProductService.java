package com.Programadores.supermarket.service;

import com.Programadores.supermarket.model.Product;
import com.Programadores.supermarket.request.ProductRequest;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface ProductService {

    Product createProduct(ProductRequest entity);
    void updateProduct(Long id,Product entity);
     List<Product> listPorducts();
    void deleteById(Long id);
}
