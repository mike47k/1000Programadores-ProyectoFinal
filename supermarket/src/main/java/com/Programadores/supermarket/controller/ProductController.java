package com.Programadores.supermarket.controller;

import com.Programadores.supermarket.model.Product;
import com.Programadores.supermarket.model.ShoppingCart;
import com.Programadores.supermarket.request.ProductRequest;
import com.Programadores.supermarket.request.ShoppingCartRequest;
import com.Programadores.supermarket.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    @PostMapping
    public ResponseEntity<Product> createProduct(@Validated @RequestBody ProductRequest request) {
        System.out.println(request);

        return ResponseEntity.ok(productService.createProduct(request));
    }

    @GetMapping
    public ResponseEntity<List<Product>> getList() {

        return ResponseEntity.ok(productService.listPorducts());
    }
}
