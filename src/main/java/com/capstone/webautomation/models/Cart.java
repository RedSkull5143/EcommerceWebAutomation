package com.capstone.webautomation.models;

public class Cart {
    private String productName;
    private String size;
    private int quantity;

    public Cart(String productName, String sizeInfo, int quantity) {
        this.productName = productName;
        this.size = sizeInfo;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "productName='" + productName + '\'' +
                ", size='" + size + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
