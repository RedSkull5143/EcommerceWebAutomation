package com.capstone.webautomation.featuretests;

import com.capstone.webautomation.BaseTest;
import com.capstone.webautomation.actions.SearchContent;
import com.capstone.webautomation.components.SearchModal;
import com.capstone.webautomation.models.User;
import com.capstone.webautomation.pages.HomePage;
import com.capstone.webautomation.pages.ProductsPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SearchProduct extends BaseTest {
    @Test
    public void verifyThatUserIsAbleToSeeTheProductPageAfterSearchingForProduct(){
        //arrange
        SearchContent searchContent= SearchContent.builder().build().init();
        HomePage homePage=new HomePage(getWebDriver());

        //arrange
        SearchModal searchModal = homePage.getHeader().openSearchModal();
        ProductsPage productsPage = searchModal.searchResult(searchContent.getInput());

        //assert
        Assert.assertTrue(productsPage.getHeading().contains("Search results"));
    }

    @Test
    public void verifyThatSearchProductIsRelevantToProductDisplayed(){
        //arrange
        SearchContent searchContent= SearchContent.builder().build().init();
        HomePage homePage=new HomePage(getWebDriver());

        //arrange
        SearchModal searchModal = homePage.getHeader().openSearchModal();
        ProductsPage productsPage = searchModal.searchResult(searchContent.getInput());

        //assert
        List<String> productNames = productsPage.getProductNames();
        for(String productName : productNames){
//            System.out.println(productName);
            Assert.assertTrue(productName.toLowerCase().contains(searchContent.getInput().toLowerCase()),"No Products Found");
        }

    }
}
