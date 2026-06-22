package com.example.commerce;

public enum UserGrade {
    BRONZE(0),
    SILVER(5),
    GOLD(10),
    PLATINUM(15);

    private final int discountRate;

    // 생성자
    UserGrade(int discountRate) {
        this.discountRate = discountRate;
    }

    // getter
    public int getDiscountRate() {
        return discountRate;
    }

}


