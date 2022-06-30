package com.Programadores.supermarket.service.impl;

import com.Programadores.supermarket.model.Role;
import com.Programadores.supermarket.model.ShoppingCart;
import com.Programadores.supermarket.model.User;
import com.Programadores.supermarket.model.UserList;
import com.Programadores.supermarket.repository.CardRepository;
import com.Programadores.supermarket.repository.RoleRepository;
import com.Programadores.supermarket.repository.ShoppingCartRepository;
import com.Programadores.supermarket.repository.UserRepository;
import com.Programadores.supermarket.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userJpaRepository;
    private final ShoppingCartRepository shoppingJpaCartRepository;
    private final CardRepository cardRepository;
    private final RoleRepository roleRepository;

    @Override
    public User updateUser(Long id, User entity) {
        return null;
    }

    @Override
    public User registerNewUser(User user) {

        ShoppingCart sc = new ShoppingCart();
        sc.setActive(true);
        sc.setTotal(0);
        sc.setDiscount(10);
        Role rol = new Role();

        user.setRole(roleRepository.save(user.getRole()));
        user.setCard(cardRepository.save(user.getCard()));
        System.out.println(user);
        sc.setUser(userJpaRepository.save(user));

        return shoppingJpaCartRepository.save(sc).getUser();
    }

    @Override
    public void deleteUser(Long id) {

    }

    @Override
    public List<User> listUsers() {
        return (List<User>) userJpaRepository.findAll();
    }

    @Override
    public ShoppingCart getActiveCart(Long id) {
        return null;
    }
}
