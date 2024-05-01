package com.capstone.webautomation.featuretests;

import com.capstone.webautomation.BaseTest;
import com.capstone.webautomation.actions.WebActions;
import com.capstone.webautomation.components.HeaderComponent;
import com.capstone.webautomation.models.User;
import com.capstone.webautomation.pages.HomePage;
import com.capstone.webautomation.pages.accounts.LoginPage;
import com.capstone.webautomation.pages.accounts.ProfilePage;
import com.capstone.webautomation.pages.accounts.RegistrationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest{
    @Test(testName = "New User Registration",description = "User is able to Register on the website")
    public void userIsAbleToRegister(){
        //arrange
        User user= User.builder().build().init();
        HomePage homePage=new HomePage(getWebDriver());
        LoginPage loginPage = homePage.getHeader().navToLoginPage();

        //act
        loginPage.navToRegisterationPage().createAccount(user);
        ProfilePage profilePage = homePage.getHeader().navToProfilePage();

        //assert
        String accountDetails= profilePage.getAccountDetails();
        Assert.assertTrue(accountDetails.contains(user.getFirst_name()));
    }

    @Test(testName = "Email ID Complusory for Registration")
    public void verifyThatUserIsNotAbleToRegisterWithEmptyEmail(){
        //arrange
        User user= User.builder().build().userWithoutEmail();
        HomePage homePage=new HomePage(getWebDriver());
        LoginPage loginPage = homePage.getHeader().navToLoginPage();
        RegistrationPage registrationPage=new RegistrationPage(getWebDriver());

        //act
        loginPage.navToRegisterationPage().createAccount(user);

        //assert
        String errorMessage = registrationPage.errorMessage();
        Assert.assertTrue(errorMessage.contains("Email can't be blank"));

    }

    @Test
    public void verifyThatUserIsNotAbleToRegisterWithEmptyPassword(){
        //arrange
        User user= User.builder().build().userWithoutPassword();
        HomePage homePage=new HomePage(getWebDriver());
        LoginPage loginPage = homePage.getHeader().navToLoginPage();
        RegistrationPage registrationPage=new RegistrationPage(getWebDriver());

        //act
        loginPage.navToRegisterationPage().createAccount(user);

        //assert
        String errorMessage = registrationPage.errorMessage();
        Assert.assertTrue(errorMessage.contains("Password can't be blank"));
    }
}
