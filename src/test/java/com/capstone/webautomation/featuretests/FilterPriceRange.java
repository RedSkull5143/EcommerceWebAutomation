package com.capstone.webautomation.featuretests;

import com.capstone.webautomation.BaseTest;
import com.capstone.webautomation.components.HeaderComponent;
import com.capstone.webautomation.modals.FilterPriceModal;
import com.capstone.webautomation.pages.HomePage;
import com.capstone.webautomation.pages.ProductsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;


public class FilterPriceRange extends BaseTest {
    @Test(testName = "Filter by price range",description = "User is able to Filter by price range")
    public void userIsAbleToFilterByPriceRange() throws InterruptedException {
        HomePage homePage = new HomePage(getWebDriver());
        HeaderComponent headerComponent = new HeaderComponent(getWebDriver());

        ProductsPage productsPage = headerComponent.navToStore();
        productsPage.clickFilterPrice();

        FilterPriceModal filterPriceModal = new FilterPriceModal(getWebDriver());
        WebElement fromPrice = filterPriceModal.getFromPrice();
        fromPrice.sendKeys("100");


        WebElement toPrice = filterPriceModal.getToPrice();
        toPrice.sendKeys("300");

        Actions actions=new Actions(getWebDriver());
        actions.doubleClick(filterPriceModal.getHead()).build().perform();

        Thread.sleep(2000);




    }


}
