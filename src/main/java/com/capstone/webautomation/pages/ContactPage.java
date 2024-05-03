package com.capstone.webautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactPage extends BasePage{

    @FindBy(xpath = "//*[@id=\"shopify-section-template--15328405586141__main\"]/div/h1")
    private WebElement contactHeading;

    public String getContactHeading() {
        return webActions.getText(contactHeading);
    }

    public ContactPage(WebDriver webDriver) {
        super(webDriver);
    }
}
