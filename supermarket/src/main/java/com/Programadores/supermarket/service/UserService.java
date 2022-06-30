package com.Programadores.supermarket.service;

import com.Programadores.supermarket.model.ShoppingCart;
import com.Programadores.supermarket.model.User;
import com.Programadores.supermarket.model.UserList;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface UserService {
    User updateUser(Long id, User entity);
    User registerNewUser(User user);
    void deleteUser(Long id);
    List<User> listUsers();

    ShoppingCart getActiveCart(Long id);
}
