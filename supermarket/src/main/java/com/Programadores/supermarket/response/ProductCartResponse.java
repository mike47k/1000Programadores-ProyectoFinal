package com.Programadores.supermarket.response;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ProductCartResponse {

    ProductResponse product  = null;
    ShoppingCartResponse shoppingCart  = null;
    long id;
    int amount;
}
