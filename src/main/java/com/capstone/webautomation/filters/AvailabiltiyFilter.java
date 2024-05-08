package com.capstone.webautomation.filters;

import com.capstone.webautomation.pages.BasePage;
import com.capstone.webautomation.pages.ProductsPage;
import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AvailabiltiyFilter{
    private WebDriver webDriver;
    @FindBy(xpath = "//*[@id=\"FacetsWrapperDesktop\"]/details[1]/summary")
    private WebElement availabiltyModal;

    public AvailabiltiyFilter(WebDriver webDriver) {
        this.webDriver=webDriver;
    }


    public ProductsPage clickInStockCheckBox(){
        WebElement inStockChecbox= webDriver.findElement(By.xpath("//*[@id=\"FacetsWrapperDesktop\"]/details[1]/div/ul/li[1]/label"));
        inStockChecbox.click();
        return new ProductsPage(webDriver);
    }
    public ProductsPage clickOutOfStockCheckBox(){
        WebElement outOfStockChecbox= webDriver.findElement(By.xpath("//*[@id=\"FacetsWrapperDesktop\"]/details[1]/div/ul/li[2]/label"));
        outOfStockChecbox.click();
        return new ProductsPage(webDriver);
    }

}
