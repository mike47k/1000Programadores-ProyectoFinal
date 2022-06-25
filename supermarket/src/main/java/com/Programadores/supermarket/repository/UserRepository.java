package com.Programadores.supermarket.repository;

import com.Programadores.supermarket.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User,Long> {
}
