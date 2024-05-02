package com.capstone.webautomation.featuretests.shopping;

import com.capstone.webautomation.BaseTest;
import com.capstone.webautomation.actions.SearchContent;
import com.capstone.webautomation.modals.SearchModal;
import com.capstone.webautomation.models.User;
import com.capstone.webautomation.pages.CartPage;
import com.capstone.webautomation.pages.HomePage;
import com.capstone.webautomation.pages.SearchedProductPage;
import com.capstone.webautomation.pages.ViewProductPage;
import com.capstone.webautomation.pages.accounts.LoginPage;
import com.capstone.webautomation.pages.accounts.ProfilePage;
import com.capstone.webautomation.utility.ViewProducts;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShopingFunctionality extends BaseTest {

    @Test
    public void userIsAbleToNavigateToStorePage() {
        HomePage homePage=new HomePage(getWebDriver());
        homePage.getHeader().navToStore();
    }

    @Test
    public void userIsAbleToNavigateToCartPage(){
        HomePage homePage=new HomePage(getWebDriver());
        CartPage cartPage = homePage.getHeader().navToCartPage();

        //assert
        Assert.assertTrue(cartPage.getCurrentURL().contains("https://web-playground.ultralesson.com/cart"));
    }

    @Test
    public void addProductAndViewCart() {
        SearchContent searchContent=SearchContent.builder().build().init();
        User user= User.builder().build().userWithValidCredentials();
        HomePage homePage=new HomePage(getWebDriver());
        ProfilePage loginPage = homePage.getHeader().navToLoginPage().login(user);

        //act
        SearchedProductPage searchedProductPage = homePage.getHeader().openSearchModal().searchResult(searchContent.getInput());
        ViewProducts viewProducts=new ViewProducts(getWebDriver());
        ViewProductPage viewProductPage = viewProducts.selectProduct();
        CartPage cartPage = viewProductPage.addToCart().viewMyCartClick();

    }
    @Test
    public void userIsAbleToAddProductAfterSearching()  {
        SearchContent searchContent= SearchContent.builder().build().init();
        HomePage homePage=new HomePage(getWebDriver());
        SearchModal searchModal = homePage.getHeader().openSearchModal();
        searchModal.searchResult(searchContent.getInput());
        ViewProducts viewProduct=new ViewProducts(getWebDriver());
        viewProduct.selectProduct();
    }
}
