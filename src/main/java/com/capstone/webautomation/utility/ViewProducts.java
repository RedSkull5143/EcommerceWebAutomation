package com.capstone.webautomation.utility;

import com.capstone.webautomation.pages.BasePage;
import com.capstone.webautomation.pages.ViewProductPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ViewProducts extends BasePage {
    @FindBy(id = "product-grid")
    private WebElement allProductsList;

    List<WebElement> allProductsHeading=allProductsList.findElements(By.tagName("h3"));

    public ViewProductPage selectProduct() {
        for(WebElement li: allProductsHeading){
            if(li.getText().contains("Sheer Dress")){
                li.click();
                break;
            }
        }
        return new ViewProductPage(webDriver);
    }

    public ViewProducts(WebDriver webDriver) {
        super(webDriver);
    }


}