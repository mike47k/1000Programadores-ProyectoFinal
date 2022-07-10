package com.Programadores.supermarket.controller;

import com.Programadores.supermarket.mapper.ProductControllerMapper;
import com.Programadores.supermarket.model.Product;
import com.Programadores.supermarket.model.ShoppingCart;
import com.Programadores.supermarket.request.ProductRequest;
import com.Programadores.supermarket.request.ShoppingCartRequest;
import com.Programadores.supermarket.response.ProductResponse;
import com.Programadores.supermarket.response.ProductResponseList;
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

    private final ProductControllerMapper mapper;
    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@Validated @RequestBody ProductRequest request) {
        System.out.println(request);
        Product product = mapper.productRequestToProduct(request);
        product = productService.createProduct(product);
        ProductResponse response = mapper.productToProductResponse(product);

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<ProductResponseList> getList() {
        List<Product> list = productService.listPorducts();
        ProductResponseList response ;
        {
            response = new ProductResponseList();
            List<ProductResponse> content = mapper.productListToProductResponseList(list);
            response.setContent(content);
        }


        return ResponseEntity.ok(response);
    }
    @PutMapping
    public ResponseEntity<ProductResponse> updateProduct(@Validated @RequestBody ProductRequest request){
        Product product = mapper.productRequestToProduct(request);
        product = productService.createProduct(product);
        ProductResponse response = mapper.productToProductResponse(product);

        return ResponseEntity.ok(response);
    }
}
