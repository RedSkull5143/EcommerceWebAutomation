package com.capstone.webautomation.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebActions {
    private WebDriver webDriver;
    protected WebDriverWait webDriverWait;

    public WebActions(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.webDriverWait=new WebDriverWait(webDriver, Duration.ofSeconds(10));
    }
}
