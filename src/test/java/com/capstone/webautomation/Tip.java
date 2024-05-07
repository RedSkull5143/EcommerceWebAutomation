package com.capstone.webautomation;

import com.capstone.webautomation.actions.SearchContent;
import com.capstone.webautomation.models.User;
import com.capstone.webautomation.pages.BillingPage;
import com.capstone.webautomation.pages.CartPage;
import com.capstone.webautomation.pages.HomePage;
import com.capstone.webautomation.pages.ViewProductPage;
import com.capstone.webautomation.utility.ViewProducts;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Tip extends BaseTest{
    @Test
    public void completeCheckOutProcess() throws InterruptedException {
        SearchContent searchContent= SearchContent.builder().build().init();
        User user= User.builder().build().userWithValidCredentials();
        HomePage homePage=new HomePage(getWebDriver());
        homePage.getHeader().navToLoginPage().login(user);
        homePage.getHeader().openSearchModal().searchResult(searchContent.getInput());
        ViewProducts viewProducts=new ViewProducts(getWebDriver());
        ViewProductPage viewProductPage = viewProducts.selectProduct();
        CartPage cartPage = viewProductPage.addToCart().viewMyCartClick();
        BillingPage billingPage = cartPage.clickCheckOutBtn();
//        Thread.sleep(5000);
        String paymentText = billingPage.getPaymentText();
        Assert.assertTrue(paymentText.contains("Payment"));
        Assert.assertEquals(billingPage.autoTotalAmount(),billingPage.totalAmount());

    }
}
