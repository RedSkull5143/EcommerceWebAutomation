package com.capstone.webautomation.modals;

import com.capstone.webautomation.pages.BasePage;
import com.capstone.webautomation.pages.CartPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartModal extends BasePage {
    @FindBy(xpath = "//*[@id=\"cart-notification-button\"]")
    private WebElement viewMyCart;

    public CartModal(WebDriver webDriver) {
        super(webDriver);
    }

    public CartPage viewMyCartClick(){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"cart-notification\"]")));
        buttonActions.click(viewMyCart);
        return new CartPage(webDriver);
    }
}
