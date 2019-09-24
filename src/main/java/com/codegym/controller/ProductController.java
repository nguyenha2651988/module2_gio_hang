package com.codegym.controller;

import com.codegym.model.GioHang;
import com.codegym.model.Products;
import com.codegym.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ProductController {


    @GetMapping("/session/{id}")
    public ModelAndView session(@PathVariable("id") Long id, Pageable pageable) {
        gioHang.increment();
        gioHang.add(id);
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("products", productsService.findAll(pageable));
        modelAndView.addObject("image", gioHang.getImage());
        modelAndView.addObject("count", gioHang.getCount());
        return modelAndView;
    }

    @Autowired
    private ProductsService productsService;

    @Autowired
    private GioHang gioHang;

    @GetMapping("/home")
    public ModelAndView listProdusts(Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/list");
        gioHang.hetHan();
        modelAndView.addObject("products", productsService.findAll(pageable));
        modelAndView.addObject("image", gioHang.getImage());
        modelAndView.addObject("count", gioHang.getCount());
        return modelAndView;
    }

    @GetMapping("/view/{id}")
    public ModelAndView viewProduct(@PathVariable("id") Long id) {
        Products products = productsService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/view");
        modelAndView.addObject("product", products);
        modelAndView.addObject("image", gioHang.getImage());
        modelAndView.addObject("count", gioHang.getCount());
        return modelAndView;
    }

    @GetMapping("/gio_hang")
    public ModelAndView giohang() {
        ModelAndView modelAndView = new ModelAndView("/giohang");
        modelAndView.addObject("products", productsService.gioHang());
        return modelAndView;
    }

}
