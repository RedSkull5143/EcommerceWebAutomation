package com.capstone.webautomation;

import com.capstone.webautomation.pages.ContactPage;
import com.capstone.webautomation.pages.HomePage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactFormTest extends BaseTest{
    @Test
    public void userIsAbleToOpenContactPage(){
        HomePage homePage=new HomePage(getWebDriver());
        homePage.getHeader().navToContactPage();
        ContactPage contactPage=new ContactPage(getWebDriver());
        String contactHeading = contactPage.getContactHeading();

        Assert.assertTrue(contactHeading.contains("Contact"));
    }
}
