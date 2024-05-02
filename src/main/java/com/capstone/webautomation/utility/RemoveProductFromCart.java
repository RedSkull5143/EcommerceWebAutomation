package com.capstone.webautomation.utility;

import com.capstone.webautomation.models.Cart;
import com.capstone.webautomation.pages.CartPage;

import java.util.List;

public class RemoveProductFromCart {
    private CartPage cartPage;

    public RemoveProductFromCart(CartPage cartPage) {
        this.cartPage = cartPage;
    }
    public void removeProductFromCart(String productName) {
        List<Cart> cartItems = cartPage.getDetails();
        for (int i = 0; i < cartItems.size(); i++) {
            Cart cartItem = cartItems.get(i);
            if (cartItem.getProductName().equals(productName)) {
                cartItems.remove(i);
                break;
            }
        }
    }
}
