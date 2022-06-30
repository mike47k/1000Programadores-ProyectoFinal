package com.Programadores.supermarket.repository;

import com.Programadores.supermarket.model.Card;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CardRepository extends PagingAndSortingRepository<Card,Long> {
}
