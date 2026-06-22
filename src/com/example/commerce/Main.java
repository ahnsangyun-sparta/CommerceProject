package com.example.commerce;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Product> elecList = new ArrayList<>(); // 전자제품
        elecList.add(new Product("Galaxy S25",1200000,"최신 안드로이드 스마트폰",50));
        elecList.add(new Product("iPhone 16",1350000,"Apple의 최신 스마트폰",50));

        Category elecCategory = new Category("전자 제품", elecList);

        List<Product> cloList = new ArrayList<>(); // 의류
        cloList.add(new Product("긴팔 티셔츠", 20000, "긴팔 무지 티셔츠", 50));
        cloList.add(new Product("여름 티셔츠",15000,"짧은 무지 티셔츠",50));

        Category cloCategory = new Category("의류",cloList);

        List<Product> foodList = new ArrayList<>(); // 식품
        foodList.add(new Product("비비교 왕교자",25000,"비비교 왕교자 만두",50));
        foodList.add(new Product("김치찌개",8000,"김치찌개",40));

        Category foodCategory = new Category("식품",foodList);

        List<Category> totalCategories = new ArrayList<>();; // Total 카테고리
        totalCategories.add(elecCategory); // 전자제품 카테고리
        totalCategories.add(cloCategory); // 의류 카테고리
        totalCategories.add(foodCategory); // 식품 카테고리

        List<ShoppingCart> emptyList = new ArrayList<>(); // 쇼핑카트 소환
        Cart myCart = new Cart(emptyList); // myCart에 emptyList 넣고

        CommerceSystem cSystem = new CommerceSystem(totalCategories,myCart); // myCart까지 파라미터로 받자
        cSystem.start();
}
}


//        Product p1 = new Product("Galaxy S25", 1200000, "최신 안드로이드 스마트폰", 50); // Product 객체 생성
//        Product p2 = new Product("iPhone 16", 1350000, "Apple의 최신 스마트폰", 50); // Product 객체 생성
//        Product p3 = new Product("MacBook Pro", 2400000, "M3 칩셋이 탑재된 노트북", 50); // Product 객체 생성
//        Product p4 = new Product("AirPods Pro", 350000, "노이즈 캔슬링 무선 이어폰", 50); // Product 객체 생성
//
//        List<Product> products = new ArrayList<>(); // CommerceSystem 클래스에서
//        Products.add(p1);
//        Products.add(p2);
//        Products.add(p3);
//        Products.add(p4);
