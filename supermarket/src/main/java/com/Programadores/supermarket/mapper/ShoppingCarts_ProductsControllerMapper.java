package com.Programadores.supermarket.mapper;

import com.Programadores.supermarket.model.ShoppingCarts_Products;
import com.Programadores.supermarket.model.User;
import com.Programadores.supermarket.response.ProductCartResponse;
import com.Programadores.supermarket.response.UserResponse;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper
public interface ShoppingCarts_ProductsControllerMapper {

    @IterableMapping(qualifiedByName = "shoppingCarts_productsToProductCartResponse")
    List<ProductCartResponse> shoppingCarts_ProductsListToProductCartListResponse(List<ShoppingCarts_Products> users);


    @Named("shoppingCarts_productsToProductCartResponse")
    ProductCartResponse shoppingCarts_ProductsToProductCartResponse(ShoppingCarts_Products shoppingCarts_products);
}
