package com.Programadores.supermarket.repository;

import com.Programadores.supermarket.model.Pay;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PayRepository extends PagingAndSortingRepository<Pay,Long> {
}
