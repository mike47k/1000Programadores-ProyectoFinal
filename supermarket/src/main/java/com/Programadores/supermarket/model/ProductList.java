package com.Programadores.supermarket.model;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class ProductList extends PageImpl<Product> {
    public ProductList(List<Product> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }
}
