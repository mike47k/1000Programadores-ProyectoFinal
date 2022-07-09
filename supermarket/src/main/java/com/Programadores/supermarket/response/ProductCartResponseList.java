package com.Programadores.supermarket.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductCartResponseList {
    private List<ProductCartResponse> content = null;
}
