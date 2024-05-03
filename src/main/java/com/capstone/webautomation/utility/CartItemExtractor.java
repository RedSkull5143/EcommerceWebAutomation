package com.capstone.webautomation.utility;

import com.capstone.webautomation.models.Cart;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CartItemExtractor {
    private WebDriver webDriver;

    public CartItemExtractor(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public List<Cart> getCartDetails() {
        List<Cart> cartItems = new ArrayList<>();
        WebElement cartItemsTable = webDriver.findElement(By.className("cart-items"));
        int tableSize = cartItemsTable.findElements(By.tagName("tr")).size();

        for (int i = 1; i <=tableSize-1; i++) {
            for (WebElement tableRow : cartItemsTable.findElements(By.tagName("tr"))) {
                if (tableRow.getAttribute("class").contains("cart-item")) {
                    String productName = tableRow.findElement(By.xpath("//*[@id=\"CartItem-"+i+"\"]/td[2]/a")).getText().trim();
                    String sizeInfo = tableRow.findElement(By.xpath("//*[@id=\"CartItem-"+i+"\"]/td[2]/dl/div/dd")).getText().trim();
//                WebElement quantityElement = tableRow.findElement(By.xpath("//*[@id=\"Quantity-1\"]"));
                    cartItems.add(new Cart(productName, sizeInfo));
                }
            }
        }
        return cartItems;
    }
}
