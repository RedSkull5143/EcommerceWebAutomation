package com.capstone.webautomation.pages.accounts;

import com.capstone.webautomation.pages.BasePage;
import com.capstone.webautomation.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage {
    @FindBy(xpath = "//*[@id=\"MainContent\"]/div/div[2]/div[2]/p")
    private WebElement accountDetailsEle;

    @FindBy(xpath = "//*[@id=\"MainContent\"]/div/div[1]/a")
    private WebElement logOutBtn;
    public ProfilePage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getAccountDetails() {
        return webActions.getText(accountDetailsEle);
    }

    public HomePage logOut(){
        buttonActions.click(logOutBtn);
        return new HomePage(webDriver);
    }

}
