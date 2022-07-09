package com.Programadores.supermarket.controller;

import com.Programadores.supermarket.mapper.ShoppingCarts_ProductsControllerMapper;
import com.Programadores.supermarket.model.ShoppingCart;
import com.Programadores.supermarket.model.ShoppingCarts_Products;
import com.Programadores.supermarket.request.CartRemoveRequest;
import com.Programadores.supermarket.request.PayRequest;
import com.Programadores.supermarket.request.ShoppingCartRequest;
import com.Programadores.supermarket.response.ProductCartResponse;
import com.Programadores.supermarket.response.ProductCartResponseList;
import com.Programadores.supermarket.service.ShoppingCartService;
import com.Programadores.supermarket.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shop")
@RequiredArgsConstructor
public class CartController {

    private final ShoppingCartService shoppingCartService;
    private final UserService userService;
    private final ShoppingCarts_ProductsControllerMapper mapper;

    @PostMapping
    public ResponseEntity<String> updateShoppingCart(@Validated @RequestBody ShoppingCartRequest request) {

        ShoppingCart cart = shoppingCartService.addProduct(request.getProductId(),shoppingCartService.getActiveCart(request.getUserId()).getId(), request.getAmount());

        return ResponseEntity.ok("siiiiiiiiiiiiiii");
    }

    @PostMapping("/pay")
    public ResponseEntity<String> payShoppingCart(@Validated @RequestBody PayRequest payRequest){
        shoppingCartService.payCart(payRequest.getIdPerson(), payRequest.getIdCart());

        return ResponseEntity.ok("siiiiiiiiiiiiiii");
    }

    @DeleteMapping("/remove")
    public ResponseEntity<String> removeCart(@Validated @RequestBody CartRemoveRequest request){
        shoppingCartService.removeProduct(request.getProductId(),request.getCartId());

        return ResponseEntity.ok("siiiiiiiiiiiiiii");
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductCartResponseList> getProducts(@PathVariable(value= "id")Long id){
        List<ShoppingCarts_Products> list = shoppingCartService.getProducts(id);
        ProductCartResponseList response;
        {
            response = new ProductCartResponseList();
            List<ProductCartResponse> content = mapper.shoppingCarts_ProductsListToProductCartListResponse(list);
            response.setContent(content);
        }
        shoppingCartService.getProducts(id);
        return ResponseEntity.ok(response);
    }


}
