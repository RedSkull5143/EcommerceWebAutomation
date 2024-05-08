package com.capstone.webautomation.pages;

import com.capstone.webautomation.filters.AvailabiltiyFilter;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//this page displays whole Products i.e store
public class ProductsPage extends BasePage{

    AvailabiltiyFilter availabiltiyFilter=new AvailabiltiyFilter(webDriver);
    public ProductsPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//*[@id=\"FacetsWrapperDesktop\"]/details[2]/summary/div/span")
    private WebElement filterPrice;

    public void clickFilterPrice(){
        filterPrice.click();
    }

    public void openAvaiabilityModal(){
        WebElement filterAvailability = webDriver.findElement(By.xpath("//*[@id=\"FacetsWrapperDesktop\"]/details[1]/summary"));
        buttonActions.click(filterAvailability);
    }
    public void closeModal(){
         WebElement btn = webDriver.findElement(By.xpath("//*[@id=\"FacetsWrapperDesktop\"]/details[1]"));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].removeAttribute('open');", btn);

    }
}


