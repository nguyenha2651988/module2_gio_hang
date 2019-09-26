package com.codegym.repository;

import com.codegym.model.Items;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ItemRepository extends PagingAndSortingRepository<Items,Long> {
}
