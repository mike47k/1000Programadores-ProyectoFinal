package com.Programadores.supermarket.repository;

import com.Programadores.supermarket.model.ShoppingCart;
import com.Programadores.supermarket.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Long> {
    Optional<User> findByEmail(String email);

}
