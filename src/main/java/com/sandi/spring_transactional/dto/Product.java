package com.sandi.spring_transactional.dto;

public class Product {

    private int id;

    private String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Product(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
