package com.Programadores.supermarket.service;

import com.Programadores.supermarket.model.User;
import com.Programadores.supermarket.model.UserList;
import org.springframework.data.domain.PageRequest;

public interface UserService {
    User updateUser(Long id, User entity);
    User registerNewUser(User user);
    void deleteUser(Long id);
    UserList listUsers(PageRequest pageRequest);
}
