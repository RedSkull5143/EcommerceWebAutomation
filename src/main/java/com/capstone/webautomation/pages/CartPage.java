package com.capstone.webautomation.pages;

import com.capstone.webautomation.models.Cart;
import com.capstone.webautomation.utility.CartItemExtractor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage{
    CartItemExtractor cartItemExtractor=new CartItemExtractor(webDriver);

    @FindBy(xpath = "//*[@id=\"Remove-1\"]/a")
    private WebElement removeProductBtn;



    public void removeProduct(){
        buttonActions.click(removeProductBtn);
//        removeProductFromCart(    );
    }
    public void removeProductFromCart(String productName) {
        List<Cart> cartItems = getDetails();
        for (int i = 0; i < cartItems.size(); i++) {
            Cart cartItem = cartItems.get(i);
            if (cartItem.getProductName().equals(productName)) {
                cartItems.remove(i);
                break;
            }
        }
    }
    public List<Cart> getDetails(){
        return cartItemExtractor.getCartDetails();
    }

    public List<String> getProductNames() {
        List<Cart> cartItems = cartItemExtractor.getCartDetails();
        List<String> productNames = new ArrayList<>();
        for (Cart cartItem : cartItems) {
            productNames.add(cartItem.getProductName());
        }
        return productNames;
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