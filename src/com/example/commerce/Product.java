package com.example.commerce;

public class Product {
    private String productName;
    private int price;
    private String productDescription;
    private int quantity;

    public Product(String productName, int price, String productDescription, int quantity) {
        this.productName = productName;
        this.price = price;
        this.productDescription = productDescription;
        this.quantity = quantity;

    }


    // getset
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;

    }
    public String getProductDescription() {
        return productDescription;
    }
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;

    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
