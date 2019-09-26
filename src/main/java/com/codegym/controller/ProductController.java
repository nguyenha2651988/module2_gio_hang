package com.codegym.controller;

import com.codegym.model.*;
import com.codegym.service.CompanyService;
import com.codegym.service.ItemService;
import com.codegym.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;


@Controller
public class ProductController {
    @Autowired
    private ProductsService productsService;

    @Autowired
    private GioHang gioHang;

    @Autowired
    private ItemService itemService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    Environment env;

    @ModelAttribute("companys")
    public Page<Company> findAllCompany(Pageable pageable) {
        return companyService.findAll(pageable);
    }

    @ModelAttribute("items")
    public Page<Items> findAllItem(Pageable pageable) {
        return itemService.findAll(pageable);
    }



    @GetMapping("/session/{id}")
    public ModelAndView session(@PathVariable("id") Long id, Pageable pageable) {
        gioHang.increment();
        gioHang.add(id);
        ModelAndView modelAndView = new ModelAndView("redirect:/home");
        return modelAndView;
    }

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

    @GetMapping("/create-from")
    public ModelAndView createForm(){
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("product", new Products());
        return modelAndView;
    }
    @PostMapping("/create-product")
    public ModelAndView createProduct(@ModelAttribute("product") ProductFile productFile, Pageable pageable){
        MultipartFile multipartFile = productFile.getImage();
        String fileName = multipartFile.getOriginalFilename();
        String fileUpload = env.getProperty("file_upload").toString();
        try {
            FileCopyUtils.copy(productFile.getImage().getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Products products = new Products(productFile.getCode(),productFile.getName(),productFile.getPrice(),
                productFile.getDescription(),fileName,productFile.getCompany(),productFile.getItems());
        productsService.save(products);
        ModelAndView modelAndView = new ModelAndView("redirect:/home");
        modelAndView.addObject("message","bạn vừa thêm 1 sản phẩm mới");
        return modelAndView;
    }

}
