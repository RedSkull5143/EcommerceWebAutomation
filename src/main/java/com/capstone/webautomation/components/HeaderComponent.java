package com.capstone.webautomation.components;

import com.capstone.webautomation.actions.ButtonAction;
import com.capstone.webautomation.modals.SearchModal;
import com.capstone.webautomation.pages.*;
import com.capstone.webautomation.pages.accounts.LoginPage;
import com.capstone.webautomation.pages.accounts.ProfilePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderComponent extends BasePage {

    @FindBy(xpath = "//*[@id=\"shopify-section-header\"]/sticky-header/header/h1/a/span")
    private WebElement logo;

    @FindBy(xpath = "//*[@id=\"shopify-section-header\"]/sticky-header/header/nav/ul/li[1]/a")
    private WebElement homeBtnEle;

    @FindBy(xpath = "//*[@id=\"shopify-section-header\"]/sticky-header/header/nav/ul/li[2]/a")
    private WebElement storeBtnEle;

    @FindBy(xpath = "//*[@id=\"shopify-section-header\"]/sticky-header/header/nav/ul/li[3]/a")
    private WebElement contactBtnEle;

    @FindBy(xpath = "//*[@id=\"shopify-section-header\"]/sticky-header/header/div/details-modal/details/summary/span")
    private WebElement searchIconEle;

    @FindBy(xpath = "//*[@id=\"shopify-section-header\"]/sticky-header/header/div/a[1]")
    private WebElement profileBtnEle;

    @FindBy(xpath = "//*[@id=\"cart-icon-bubble\"]")
    private WebElement cartBtnEle;

    public HeaderComponent(WebDriver webDriver) {
        super(webDriver);
        this.buttonActions=new ButtonAction(webDriver);
    }

    public HomePage navToHomePageUsingLogo(){
        buttonActions.click(logo);
        return new HomePage(webDriver);
    }

    public HomePage navToHomePageUsingHomeButton(){
        buttonActions.click(homeBtnEle);
        return new HomePage(webDriver);
    }

    public ProductsPage navToStore(){
        buttonActions.click(storeBtnEle);
        return new ProductsPage(webDriver);
    }

    public ContactPage navToContactPage(){
        buttonActions.click(contactBtnEle);
        return new ContactPage(webDriver);
    }

    public SearchModal openSearchModal(){
        buttonActions.click(searchIconEle);
        return new SearchModal(webDriver);
    }

    public LoginPage navToLoginPage(){
        buttonActions.click(profileBtnEle);
        return new LoginPage(webDriver);
    }

    public ProfilePage navToProfilePage(){
        buttonActions.click(profileBtnEle);
        return new ProfilePage(webDriver);
    }

    public CartPage navToCartPage(){
        buttonActions.click(cartBtnEle);
        return new CartPage(webDriver);
    }

}
