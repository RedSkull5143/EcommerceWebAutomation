package com.capstone.webautomation;

import com.capstone.webautomation.models.FeedBack;
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

    @Test
    public void userIsAbleToSubmitContactFormWithValidData() throws InterruptedException {
        FeedBack feedBack=FeedBack.builder().build().validDetails();
        HomePage homePage=new HomePage(getWebDriver());
        homePage.getHeader().navToContactPage();
        ContactPage contactPage=new ContactPage(getWebDriver());
        contactPage.sendFeedback(feedBack);
        Thread.sleep(5000);
        String successMessage = contactPage.getSuccessMessage();
        System.out.println(successMessage);
        Assert.assertTrue(successMessage.contains("Thanks for contacting us. We'll get back to you as soon as possible."));
    }
}
