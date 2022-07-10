package com.Programadores.supermarket.response;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ProductResponse {
    long id;
    String name;
    String brand;
    String image;
    long stock;
    double price;
}
