package com.Programadores.supermarket.service.impl;

import com.Programadores.supermarket.model.*;
import com.Programadores.supermarket.repository.*;
import com.Programadores.supermarket.service.ShoppingCartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ShoppingCartRepository shoppingCartJpaRepository;
    private final ProductRepository productJpaRepository;
    private final ShoppingCarts_ProductsRepository shoppingCarts_productsJpaRepository;
    private final UserRepository userJpaRepository;
    private final PayRepository payJpaRepository;

    public static double total=0;

    @Override
    public ShoppingCart createShoppingCart(ShoppingCart entity) {
        return shoppingCartJpaRepository.save(entity);
    }

    @Override
    public ShoppingCart updateShoppingCart(Long id, ShoppingCart entity) {
        return null;
    }

    @Override
    public ShoppingCart getShoppingCartById(Long id) {
        return shoppingCartJpaRepository.findById(id).orElseThrow(()-> new RuntimeException());
    }

    @Override
    public ShoppingCart getActiveCart(Long userId) {
        return shoppingCartJpaRepository.findByIsActiveAndUserId(true,userId);
    }

    @Override
    public ShoppingCart addProduct(Long ProductId, Long shoppingCart ,int amount) {
        Optional<ShoppingCarts_Products> cartProductOptional = shoppingCarts_productsJpaRepository.findByShoppingCartIdAndProductId(shoppingCart,ProductId);
        if(cartProductOptional.isPresent()){
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            ShoppingCarts_Products cp = cartProductOptional.get();

            cp.getShoppingCart().getShoppingCarts_products().forEach(scp -> {
                if (scp.getId() == cp.getId()){
                    total = total + (amount*scp.getProduct().getPrice());
                }else{
                    total = total + (scp.getAmount()*scp.getProduct().getPrice());
                }

            });
            cp.getShoppingCart().setTotal(total);
            cp.setAmount(amount);
            return shoppingCarts_productsJpaRepository.save(cp).getShoppingCart();

        }else {
            ShoppingCart cart = shoppingCartJpaRepository.findById(shoppingCart).orElseThrow();
            Product product = productJpaRepository.findById(ProductId).orElseThrow();
            ShoppingCarts_Products cp = new ShoppingCarts_Products();
            cp.setProduct(product);
            cart.setTotal(cart.getTotal()+(amount*product.getPrice()));
            cp.setShoppingCart(cart);
            cp.setAmount(amount);
            return shoppingCarts_productsJpaRepository.save(cp).getShoppingCart();
        }
    }

    @Override
    public void removeProduct(Long ProductId, Long shoppingCart) {
        shoppingCarts_productsJpaRepository.findByShoppingCartIdAndProductId(shoppingCart,ProductId)
                .ifPresent(shoppingCarts_productsJpaRepository::delete);
        total = 0;
        ShoppingCart sc = shoppingCartJpaRepository.findById(shoppingCart).get();
        sc.getShoppingCarts_products().forEach(scp -> {
                total = total + (scp.getAmount()*scp.getProduct().getPrice());
        });
        sc.setTotal(total);
        shoppingCartJpaRepository.save(sc);
    }

    @Override
    public void payCart(Long idUser,Long idCart) {
        ShoppingCart c = shoppingCartJpaRepository.findById(idCart).get();
        User u = userJpaRepository.findById(idUser).get();
        c.setActive(false);
        Pay pay = new Pay();
        pay.setTotal(c.getTotal()*(c.getDiscount()/100));
        pay.setAddress(u.getAddress());
        pay.setShoppingCart(c);
        payJpaRepository.save(pay);
        ShoppingCart sc = new ShoppingCart();
        sc.setActive(true);
        sc.setTotal(0);
        sc.setDiscount(10);
        sc.setUser(u);
        shoppingCartJpaRepository.save(sc);



    }

    @Override
    public List<ShoppingCarts_Products> getProducts(long id) {
        return shoppingCarts_productsJpaRepository.findByShoppingCartId(id);
    }
}
