package com.capstone.webautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{

    public String getCurrentURL(){
        return webDriver.getCurrentUrl();
    }
    public CartPage(WebDriver webDriver) {
        super(webDriver);
    }
}
