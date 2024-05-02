package com.capstone.webautomation.models;

import lombok.Data;

@Data
public class Cart {
    private String productName;
    private String size;
    private int quantity;

    public Cart(String productName, String sizeInfo) {
        this.productName = productName;
        this.size = sizeInfo;
//        this.quantity = Integer.parseInt(quantity);
    }

    @Override
    public String toString() {
        return "Cart{" +
                "productName='" + productName + '\'' +
                ", size='" + size + '\'' +
                '}';
    }

    public String getSizeInfo() {
        return size;
    }
}
