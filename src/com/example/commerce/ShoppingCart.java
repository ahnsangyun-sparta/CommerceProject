package com.example.commerce;

public class ShoppingCart {
    private String productName;
    private int price;
    private int quantity;


    // 생성자

    ShoppingCart(String productName, int price, int quantity) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;


    }

    // getset
    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;

    }

    public void setPrice(int price) {
        this.price = price;
    }
}
