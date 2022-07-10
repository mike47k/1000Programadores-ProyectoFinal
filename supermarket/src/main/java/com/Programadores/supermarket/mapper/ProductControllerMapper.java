package com.Programadores.supermarket.mapper;

import com.Programadores.supermarket.model.Product;
import com.Programadores.supermarket.model.User;
import com.Programadores.supermarket.request.ProductRequest;
import com.Programadores.supermarket.request.UserRequest;
import com.Programadores.supermarket.response.ProductResponse;
import com.Programadores.supermarket.response.UserResponse;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper
public interface ProductControllerMapper {

    Product productRequestToProduct(ProductRequest request);
    @Named("productToProductResponse")
    ProductResponse productToProductResponse(Product request);

    @IterableMapping(qualifiedByName = "productToProductResponse")
    List<ProductResponse> productListToProductResponseList(List<Product> list);
}
