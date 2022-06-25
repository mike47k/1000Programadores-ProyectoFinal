package com.Programadores.supermarket.service.impl;

import com.Programadores.supermarket.model.Product;
import com.Programadores.supermarket.model.ProductList;
import com.Programadores.supermarket.repository.ProductRepository;
import com.Programadores.supermarket.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productJpaRepository;
    @Override
    @Transactional
    public Product createProduct(Product entity) {
        return productJpaRepository.save(entity);
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
    public ProductList listPorducts(PageRequest pageRequest) {
        Page<Product> page = productJpaRepository.findAll(pageRequest);
        return new ProductList(page.getContent(),pageRequest,page.getTotalElements());
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        productJpaRepository.findById(id).ifPresent(productJpaRepository::delete);
    }
}
