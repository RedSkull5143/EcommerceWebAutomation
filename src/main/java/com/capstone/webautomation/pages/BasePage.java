package com.capstone.webautomation.pages;

import com.capstone.webautomation.actions.ButtonAction;
import com.capstone.webautomation.actions.TextBox;
import com.capstone.webautomation.components.HeaderComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    protected WebDriver webDriver;
    protected ButtonAction buttonActions;
    protected TextBox textBox;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }

    public HeaderComponent getHeader(){
        return new HeaderComponent(webDriver);
    }
}
