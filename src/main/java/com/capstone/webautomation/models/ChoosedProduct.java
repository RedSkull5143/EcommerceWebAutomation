package com.capstone.webautomation.models;

import com.capstone.webautomation.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChoosedProduct extends BasePage {
    @FindBy(xpath = "//*[@id=\"ProductInfo-template--15328405717213__main\"]/p[1]")
    private WebElement seller;

    @FindBy(xpath = "//*[@id=\"ProductInfo-template--15328405717213__main\"]/h1")
    private WebElement productName;

    @FindBy(xpath = "//*[@id=\"price-template--15328405717213__main\"]/div/div/div[1]/span[2]")
    private WebElement regularPrice;

    public ChoosedProduct(WebDriver webDriver) {
        super(webDriver);
    }

    public String getProductName(){
        return webActions.getText(productName);
    }
    public String getSellerName(){
        return webActions.getText(seller);
    }
    public String getPrice(){
        return webActions.getText(regularPrice);
    }
}
