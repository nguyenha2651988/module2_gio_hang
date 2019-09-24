package com.codegym.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "items")
public class Items {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @OneToMany(targetEntity = Products.class,mappedBy = "items")
    private List<Products> products;

    public Items() {
    }

    public Items(String name, List<Products> products) {
        this.name = name;
        this.products = products;
    }
}
