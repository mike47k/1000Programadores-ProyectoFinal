package com.Programadores.supermarket.controller;

import com.Programadores.supermarket.mapper.ShoppingCarts_ProductsControllerMapper;
import com.Programadores.supermarket.model.Pay;
import com.Programadores.supermarket.model.ShoppingCart;
import com.Programadores.supermarket.model.ShoppingCarts_Products;
import com.Programadores.supermarket.request.CartRemoveRequest;
import com.Programadores.supermarket.request.PayRequest;
import com.Programadores.supermarket.request.ShoppingCartRequest;
import com.Programadores.supermarket.response.PayResponse;
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
    public ResponseEntity<ProductCartResponseList> addProduct(@Validated @RequestBody ShoppingCartRequest request) {

        shoppingCartService.addProduct(request.getProductId(),shoppingCartService.getActiveCart(request.getUserId()).getId(), request.getAmount());
        List<ShoppingCarts_Products> list = shoppingCartService.getProducts(shoppingCartService.getActiveCart(request.getUserId()).getId());
        ProductCartResponseList response;
        {
            response = new ProductCartResponseList();
            List<ProductCartResponse> content = mapper.shoppingCarts_ProductsListToProductCartListResponse(list);
            response.setContent(content);
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping("/pay")
    public ResponseEntity<PayResponse> payShoppingCart(@Validated @RequestBody PayRequest payRequest){
        Pay pay = shoppingCartService.payCart(payRequest.getIdPerson(), payRequest.getIdCart());
        List<ShoppingCarts_Products> list = shoppingCartService.getCart(payRequest.getIdCart()).getShoppingCarts_products();
        PayResponse response;
        {
            response = new PayResponse();
            List<ProductCartResponse> content = mapper.shoppingCarts_ProductsListToProductCartListResponse(list);
            response.setContent(content);
        }
        response.setTotal(pay.getTotal());
        response.setId(pay.getId());
        response.setAddress(pay.getAddress());
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/remove")
    public ResponseEntity<ProductCartResponseList> removeProduct(@Validated @RequestBody CartRemoveRequest request){
        shoppingCartService.removeProduct(request.getProductId(),request.getCartId());
        List<ShoppingCarts_Products> list = shoppingCartService.getProducts(request.getCartId());

        ProductCartResponseList response;
        {
            response = new ProductCartResponseList();
            List<ProductCartResponse> content = mapper.shoppingCarts_ProductsListToProductCartListResponse(list);
            response.setContent(content);
        }
        return ResponseEntity.ok(response);
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
        return ResponseEntity.ok(response);
    }


}
