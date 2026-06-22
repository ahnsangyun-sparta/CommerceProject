package com.example.commerce;

import java.util.List;

public class Cart {
    private final List<ShoppingCart> cartList;

    public Cart(List<ShoppingCart> cartList) {
        this.cartList = cartList;
    }

    //getset

    public List<ShoppingCart> getCartList() {
        return cartList;
    }

    public void addItem(String productName, int price, int quantity) {

        for (int i = 0; i < cartList.size(); i++) {
            ShoppingCart checkItem = cartList.get(i);

            if (checkItem.getProductName().equals(productName)) { //
                int plusQuantity = checkItem.getQuantity() + quantity;
                checkItem.setQuantity(plusQuantity);

                System.out.println("기존 상품 -> " + productName + "가 장바구니에 " + quantity + "개 더 추가 되었습니다." + "총 : " + plusQuantity + "개");
                return;
            }

        }
        ShoppingCart checkItem = new ShoppingCart(productName, price, quantity);
        cartList.add(checkItem);
        System.out.println(productName + "가 장바구니에 추가되었습니다.");
    }
}
