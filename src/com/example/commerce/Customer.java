package com.example.commerce;

public class Customer {
    private String customerName;
    private String email;
    private String rating;


    public Customer(String customerName, String email, String rating) {
        this.customerName = customerName;
        this.email = email;
        this.rating = rating;

    }

    public String getCustomerName() {return customerName;}
    public String getEmail() {return email;}
    public String getRating() {return rating;}

    public void setCustomerName(String customerName) {this.customerName = customerName;}
    public void setEmail(String email) {this.email = email;}
    public void setRating(String rating) {this.rating = rating;}



}
