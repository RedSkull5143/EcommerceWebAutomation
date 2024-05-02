package com.capstone.webautomation.pages;

import com.capstone.webautomation.models.Cart;
import com.capstone.webautomation.utility.CartItemExtractor;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class CartPage extends BasePage{
    CartItemExtractor cartItemExtractor=new CartItemExtractor(webDriver);

    public void getDetails(){
        cartItemExtractor.getCartDetails();
    }

    public void printCartDetails() {
        List<Cart> cartItems = cartItemExtractor.getCartDetails();
        System.out.println("Cart Details:");
        System.out.println("-------------");
        for (Cart cartItem : cartItems) {
            System.out.println("Product Name: " + cartItem.getProductName());
            System.out.println("Size Info: " + cartItem.getSizeInfo());
            System.out.println("-------------");
        }
    }
    public String getCurrentURL(){
        return webDriver.getCurrentUrl();
    }
    public CartPage(WebDriver webDriver) {
        super(webDriver);
    }
}