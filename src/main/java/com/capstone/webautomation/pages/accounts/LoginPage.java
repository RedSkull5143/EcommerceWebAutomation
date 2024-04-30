package com.capstone.webautomation.pages.accounts;

import com.capstone.webautomation.actions.WebActions;
import com.capstone.webautomation.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "CustomerEmail")
    private WebElement emailIdBox;

    @FindBy(id = "CustomerPassword")
    private WebElement passwordBox;

    @FindBy(xpath = "//*[@id=\"customer_login\"]/a[1]")
    private WebElement forgotPasswordLinkEle;

    @FindBy(xpath = "//*[@id=\"customer_login\"]/button")
    private WebElement signInBtnEle;

    @FindBy(xpath = "//*[@id=\"customer_login\"]/a[2]")
    private WebElement createAccountLinkEle;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }


}
