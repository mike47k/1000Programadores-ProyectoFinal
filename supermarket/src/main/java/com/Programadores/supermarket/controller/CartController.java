package com.Programadores.supermarket.controller;

import com.Programadores.supermarket.model.ShoppingCart;
import com.Programadores.supermarket.request.ShoppingCartRequest;
import com.Programadores.supermarket.service.ShoppingCartService;
import com.Programadores.supermarket.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/shop")
@RequiredArgsConstructor
public class CartController {

    private final ShoppingCartService shoppingCartService;
    private final UserService userService;

    @PostMapping
    public ResponseEntity<String> updateShoppingCart(@Validated @RequestBody ShoppingCartRequest request) {

        ShoppingCart cart = shoppingCartService.addProduct(request.getProductId(),shoppingCartService.getActiveCart(request.getUserId()).getId(), request.getAmount());

        return ResponseEntity.ok("siiiiiiiiiiiiiii");
    }


}
