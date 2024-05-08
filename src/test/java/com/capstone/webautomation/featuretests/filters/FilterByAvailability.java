package com.capstone.webautomation.featuretests.filters;

import com.capstone.webautomation.BaseTest;
import com.capstone.webautomation.filters.AvailabiltiyFilter;
import com.capstone.webautomation.pages.HomePage;
import com.capstone.webautomation.pages.ProductsPage;
import com.capstone.webautomation.pages.ViewProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.sound.midi.ShortMessage;
import java.util.HashMap;

public class FilterByAvailability extends BaseTest {
    @Test
    public void userAbleToSeeInStockProducts(){
        HomePage homePage=new HomePage(getWebDriver());
        homePage.getHeader().navToStore().openAvaiabilityModal();
        AvailabiltiyFilter availabiltiyFilter=new AvailabiltiyFilter(getWebDriver());
        availabiltiyFilter.clickInStockCheckBox();
        ProductsPage productsPage=new ProductsPage(getWebDriver());
        productsPage.closeModal();
        String s = productsPage.availBtn();
        Assert.assertEquals(s,"In Stock");
    }

    @Test
    public void userAbleToSeeOutOfStockProducts(){
        HomePage homePage=new HomePage(getWebDriver());
        homePage.getHeader().navToStore().openAvaiabilityModal();
        AvailabiltiyFilter availabiltiyFilter=new AvailabiltiyFilter(getWebDriver());
        availabiltiyFilter.clickOutOfStockCheckBox();
        ProductsPage productsPage=new ProductsPage(getWebDriver());
        productsPage.closeModal();
    }

    @Test
    public void userIsNotToBuyInStockProduct() {
        HomePage homePage=new HomePage(getWebDriver());
        homePage.getHeader().navToStore().openAvaiabilityModal();
        AvailabiltiyFilter availabiltiyFilter=new AvailabiltiyFilter(getWebDriver());
        availabiltiyFilter.clickInStockCheckBox();
        ProductsPage productsPage=new ProductsPage(getWebDriver());
        productsPage.closeModal();
        ViewProductPage viewProductPage = productsPage.openFirstProduct();
        Assert.assertTrue(viewProductPage.getBuyNowBtn().isEnabled());
    }
    @Test
    public void userIsNotAbleToBuyTheOutOfStockProduct(){
        HomePage homePage=new HomePage(getWebDriver());
        homePage.getHeader().navToStore().openAvaiabilityModal();
        AvailabiltiyFilter availabiltiyFilter=new AvailabiltiyFilter(getWebDriver());
        availabiltiyFilter.clickOutOfStockCheckBox();
        ProductsPage productsPage=new ProductsPage(getWebDriver());
        productsPage.closeModal();
        ViewProductPage viewProductPage = productsPage.openFirstProduct();
        Assert.assertFalse(viewProductPage.getSoldOutBtn().isEnabled());
    }
}
