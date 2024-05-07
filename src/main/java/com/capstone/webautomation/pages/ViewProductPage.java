package com.capstone.webautomation.pages;

import com.capstone.webautomation.modals.CartModal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

//full information of product page.
public class ViewProductPage extends BasePage{
    @FindBy(xpath = "//*[@id=\"ProductInfo-template--15328405717213__main\"]/p[1]")
    private WebElement seller;

    @FindBy(className = "product__title")
    private WebElement productTitle;

    private WebElement selectedRadio = null;
    List<WebElement> sizeRadioButtons = webDriver.findElements(By.name("Size"));

    public String getSizeSelected() {
        for (WebElement i : sizeRadioButtons) {
            if (i.isSelected()) {
                selectedRadio = i;
                return i.getAttribute("value");
            }
        }
        return null;
    }

    private WebElement colorSelected=null;
    List<WebElement> colorRadioButtons=webDriver.findElements(By.name("Color"));

    public String getColorSelected(){
        for(WebElement i: colorRadioButtons){
            if(i.isSelected()){
                colorSelected=i;
                return i.getAttribute("value");
            }
        }
        return null;
    }

    @FindBy(xpath = "//*[@id=\"product-form-template--15328405717213__main\"]/div/button")
    private WebElement addToCartBtn;

    public CartModal addToCart(){
        buttonActions.click(addToCartBtn);
        return new CartModal(webDriver);
    }

    public ViewProductPage(WebDriver webDriver) {
        super(webDriver);
    }
}