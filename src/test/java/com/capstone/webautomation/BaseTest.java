package com.capstone.webautomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    public static ThreadLocal<WebDriver> driverThreadLocal=new ThreadLocal<>();
    public static final String URL="https://web-playground.ultralesson.com/";

    @BeforeMethod
    public void setUp(){
        WebDriver webDriver=new ChromeDriver();
        driverThreadLocal.set(webDriver);
        launch();
        driverThreadLocal.get().manage().window().maximize();
    }

    private void launch() {
        driverThreadLocal.get().get(URL);
    }

    public WebDriver getWebDriver(){
        return driverThreadLocal.get();
    }

    @AfterMethod
    public void tearDown(){
        driverThreadLocal.get().quit();
    }


}
