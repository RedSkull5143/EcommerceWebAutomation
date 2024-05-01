package com.capstone.webautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class ProductsPage extends BasePage{

    @FindBy(xpath = "//*[@id=\"shopify-section-template--15328405553373__main\"]/div/div[1]/h1")
    private WebElement searchHeadingEle;

    @FindBy(xpath = "//*[@id=\"product-grid\"]/ul")
    private WebElement allProductsGridEle;

    private List<WebElement> productNameElements=allProductsGridEle.findElements(By.tagName("h3"));

    @FindBy(xpath = "//*[@id=\"product-grid\"]/div[2]/nav/ul")
    private WebElement pagination;

    private List<WebElement> pages=pagination.findElements(By.tagName("a"));

    @FindBy(xpath = "//*[@id=\"product-grid\"]/div[2]/nav/ul/li[1]/a")
    private WebElement previousPageArrow;

    @FindBy(xpath = "//*[@id=\"product-grid\"]/div[2]/nav/ul/li[8]/a")
    private WebElement nextPageArrow;

    public ProductsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getHeading(){
        return webActions.getText(searchHeadingEle);
    }

    public List<String> getProductNames() {
        return productNameElements.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    private int getTotalPages(){
        return pages.size();
    }

    private void goToPreviousPage(){
        buttonActions.click(previousPageArrow);
    }

    private void goToNextPage(){
        buttonActions.click(nextPageArrow);
    }

}
