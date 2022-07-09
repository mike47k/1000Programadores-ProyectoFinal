package com.Programadores.supermarket.service.impl;

import com.Programadores.supermarket.model.Product;
import com.Programadores.supermarket.repository.ProductRepository;
import com.Programadores.supermarket.request.ProductRequest;
import com.Programadores.supermarket.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productJpaRepository;
    @Override
    @Transactional
    public Product createProduct(ProductRequest entity) {
        Product p = new Product();
        p.setBrand(entity.getBrand());
        p.setName(entity.getName());
        p.setPrice(entity.getPrice());
        p.setStock(entity.getStock());

        return productJpaRepository.save(p);
    }

    @Override
    @Transactional
    public void updateProduct(Long id, Product entity) {
        productJpaRepository.findById(id).map(productJpa->{
            Optional.ofNullable(entity.getBrand()).ifPresent(productJpa::setBrand);
            Optional.ofNullable(entity.getName()).ifPresent(productJpa::setName);
            Optional.ofNullable(entity.getPrice()).ifPresent(productJpa::setPrice);
            Optional.ofNullable(entity.getStock()).ifPresent(productJpa::setStock);
            return productJpaRepository.save(productJpa);
        }).orElseThrow(() -> new RuntimeException());
    }

    @Override
    @Transactional
    public List<Product> listPorducts() {

        return (List<Product>) productJpaRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        productJpaRepository.findById(id).ifPresent(productJpaRepository::delete);
    }


}
