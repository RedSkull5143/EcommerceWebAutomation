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
    public void defaultTip() throws InterruptedException {
        SearchContent searchContent= SearchContent.builder().build().init();
        User user= User.builder().build().userWithValidCredentials();
        HomePage homePage=new HomePage(getWebDriver());
        homePage.getHeader().navToLoginPage().login(user);
        homePage.getHeader().openSearchModal().searchResult(searchContent.getInput());
        ViewProducts viewProducts=new ViewProducts(getWebDriver());
        ViewProductPage viewProductPage = viewProducts.selectProduct();
        CartPage cartPage = viewProductPage.addToCart().viewMyCartClick();
        BillingPage billingPage = cartPage.clickCheckOutBtn();
        Thread.sleep(5000);
        String paymentText = billingPage.getPaymentText();
        Assert.assertTrue(paymentText.contains("Payment"));
//        System.out.println(billingPage.tipAmount());
        System.out.println(billingPage.getSubTotal());
        System.out.println(billingPage.offer());
        System.out.println(billingPage.taxValue());
        System.out.println(billingPage.tipAmount());
        System.out.println(billingPage.totalAmount());
        System.out.println(billingPage.autoTotalAmount());
        Assert.assertEquals(billingPage.autoTotalAmount(),billingPage.totalAmount());

        billingPage.selectPayment();
        billingPage.completeOrder();

        String confirmationMessage = billingPage.getConfirmationMessage();
        Assert.assertTrue(confirmationMessage.contains("Your order is confirmed"));


    }
}
