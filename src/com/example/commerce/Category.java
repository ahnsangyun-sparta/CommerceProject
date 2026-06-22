package com.example.commerce;

import java.util.List;

public class Category {
    private final String categoryName;

    // Category 클래스가 관리하도록 변경
    private final List<Product> products; // Product 클래스를 List로 관리

//    public Category(List<Product> products) {
//        this.products = products;
//    }

    public Category(String categoryName, List<Product> products) {
        this.categoryName = categoryName;
        this.products = products;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public List<Product> getProducts() {
        return products;
    }

}

