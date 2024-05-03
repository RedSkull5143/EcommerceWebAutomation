package com.capstone.webautomation.pages;

import com.capstone.webautomation.models.FeedBack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ContactPage extends BasePage{

    @FindBy(xpath = "//*[@id=\"shopify-section-template--15328405586141__main\"]/div/h1")
    private WebElement contactHeading;

    @FindBy(id = "ContactForm-name")
    private WebElement name;

    @FindBy(id = "ContactForm-email")
    private WebElement emailID;

    @FindBy(id = "ContactForm-phone")
    private WebElement phoneNo;

    @FindBy(id = "ContactForm-body")
    private WebElement comment;

    @FindBy(css = ".contact_button button[type=\"submit\"]")
    private WebElement sendBtn;

    @FindBy(xpath = "//*[@id=\"ContactForm\"]/div[1]")
    private WebElement successMessage;

    @FindBy(xpath = "//*[@id=\"shopify-section-template--15328405586141__main\"]/div/h1")
    private WebElement side;
    public String getContactHeading() {
        return webActions.getText(contactHeading);
    }

    public String getSuccessMessage() {
        return webActions.getText(successMessage);
    }

    public void sendFeedback(FeedBack feedBack){
        textBox.type(name, feedBack.getName());
        textBox.type(emailID, feedBack.getEmailID());
        textBox.type(phoneNo, feedBack.getPhoneNo());
        textBox.type(comment, feedBack.getComment());
//        buttonActions.click(side);
        sendBtn.submit();
        new ContactPage(webDriver);
    }
    public ContactPage(WebDriver webDriver) {
        super(webDriver);
    }
}
