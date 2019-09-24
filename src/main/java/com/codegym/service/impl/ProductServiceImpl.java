package com.codegym.service.impl;

import com.codegym.model.GioHang;
import com.codegym.model.Products;
import com.codegym.repository.ProductsRepository;
import com.codegym.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.ArrayList;
import java.util.List;


public class ProductServiceImpl implements ProductsService{

    @Autowired
    private ProductsRepository productsRepository;
    @Autowired
    private GioHang gioHang;

    @Override
    public Page<Products> findAll(Pageable pageable) {
        return productsRepository.findAll(pageable);
    }

    @Override
    public Products findById(Long id) {
        return productsRepository.findOne(id);
    }

    @Override
    public void save(Products products) {
        productsRepository.save(products);
    }

    @Override
    public void delete(Long id) {
        productsRepository.delete(id);
    }

    @Override
    public List<Products> gioHang() {
        List<Products> products = new ArrayList<>();
        for (Long product : gioHang.getArray()) {
            products.add(productsRepository.findOne(product));
        }
        return products;
    }
}

