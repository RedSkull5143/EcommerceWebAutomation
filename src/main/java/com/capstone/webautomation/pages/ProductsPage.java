package com.capstone.webautomation.pages;

import com.capstone.webautomation.filters.AvailabiltiyFilter;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//this page displays whole Products i.e store
public class ProductsPage extends BasePage{

    AvailabiltiyFilter availabiltiyFilter=new AvailabiltiyFilter(webDriver);
    public ProductsPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//*[@id=\"FacetsWrapperDesktop\"]/details[2]/summary/div/span")
    private WebElement filterPrice;

    @Getter
    @FindBy(xpath = "//*[@id=\"product-grid\"]/li[1]/div/div[1]/div/h3/a")
    private WebElement firstProduct;

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
    public String availBtn(){
        WebElement getAvailText=webDriver.findElement(By.xpath("//*[@id=\"FacetFiltersForm\"]/div[2]/facet-remove[1]/a/span"));
        WebDriverWait webDriverWait=new WebDriverWait(webDriver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.visibilityOf(getAvailText));
        String text = getAvailText.getText();
        return text;
    }

    public ViewProductPage openFirstProduct(){
        firstProduct.click();
        return new ViewProductPage(webDriver);
    }

}


