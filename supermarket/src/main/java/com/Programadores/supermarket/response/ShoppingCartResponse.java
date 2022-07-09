package com.Programadores.supermarket.response;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ShoppingCartResponse {
    long idCart;
    double total;
    int discount;
}
