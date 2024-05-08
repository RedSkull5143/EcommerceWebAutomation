package com.capstone.webautomation.featuretests.shopping;

import com.capstone.webautomation.BaseTest;
import com.capstone.webautomation.actions.SearchContent;
import com.capstone.webautomation.modals.SearchModal;
import com.capstone.webautomation.models.Cart;
import com.capstone.webautomation.models.User;
import com.capstone.webautomation.pages.CartPage;
import com.capstone.webautomation.pages.HomePage;
import com.capstone.webautomation.pages.SearchedProductPage;
import com.capstone.webautomation.pages.ViewProductPage;
import com.capstone.webautomation.pages.accounts.LoginPage;
import com.capstone.webautomation.pages.accounts.ProfilePage;
import com.capstone.webautomation.utility.CartItemExtractor;
import com.capstone.webautomation.utility.ViewProducts;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

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
    public void userIsAbleToAddProductAfterSearching()  {
        SearchContent searchContent= SearchContent.builder().build().init();
        HomePage homePage=new HomePage(getWebDriver());
        SearchModal searchModal = homePage.getHeader().openSearchModal();
        searchModal.searchResult(searchContent.getInput());
        ViewProducts viewProduct=new ViewProducts(getWebDriver());
        ViewProductPage viewProductPage = viewProduct.selectProduct();
        CartPage cartPage = viewProductPage.addToCart().viewMyCartClick();
        cartPage.printCartDetails();
        List<String> productNames = cartPage.getProductNames();
        String productAdded = searchContent.selectDress();
        Assert.assertFalse(productNames.isEmpty());
        Assert.assertTrue(productNames.contains(productAdded));
    }

    @Test
    public void testCartPersistenceAcrossSessions() {
        // Step 1: Add products to the cart in one session
        SearchContent searchContent = SearchContent.builder().build().init();
        HomePage homePage = new HomePage(getWebDriver());
        User user= User.builder().build().userWithValidCredentials();
        homePage.getHeader().navToLoginPage().login(user);
        SearchModal searchModal = homePage.getHeader().openSearchModal();
        searchModal.searchResult(searchContent.getInput());
        ViewProducts viewProduct = new ViewProducts(getWebDriver());
        ViewProductPage viewProductPage = viewProduct.selectProduct();
        CartPage cartPage = viewProductPage.addToCart().viewMyCartClick();
        List<String> productNames = cartPage.getProductNames();

        //Log out
        homePage.getHeader().navToProfilePage().logOut();

        //Log back in
        homePage.getHeader().navToLoginPage().login(user);

        //Assert
        CartPage loggedInCartPage = new HomePage(getWebDriver()).getHeader().navToCartPage();
        List<String> loggedInProductNames = loggedInCartPage.getProductNames();
        Assert.assertTrue(loggedInProductNames.containsAll(productNames));
    }

    @Test
    public void deleteProductFromCart(){
        SearchContent searchContent= SearchContent.builder().build().init();
        HomePage homePage=new HomePage(getWebDriver());
        SearchModal searchModal = homePage.getHeader().openSearchModal();
        searchModal.searchResult(searchContent.getInput());
        ViewProducts viewProduct=new ViewProducts(getWebDriver());
        ViewProductPage viewProductPage = viewProduct.selectProduct();
        CartPage cartPage = viewProductPage.addToCart().viewMyCartClick();

    }
}