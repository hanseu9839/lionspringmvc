package org.example.lionspringmvc.domain;


import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Product {
    String name;
    Double price;

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }
}
