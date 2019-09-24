package com.codegym.service;

import com.codegym.model.GioHang;
import com.codegym.model.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface ProductsService {
    Page<Products> findAll(Pageable pageable);

    Products findById(Long id);

    void save(Products products);

    void delete(Long id);

    List<Products> gioHang();
}
