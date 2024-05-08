package com.capstone.webautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.SplittableRandom;


public class BillingPage extends BasePage{

    @FindBy(xpath = "//span[@class='_19gi7yt0 _19gi7ytl _1fragemp2 _19gi7yt1 notranslate']")
    private WebElement subTotal;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div/div[1]/div/div[2]/div/aside/div/section/div/section/div[2]/div[3]/div[2]/span")
    private WebElement offerDiscount;

    @FindBy(xpath = "//*[@id=\"Form1\"]/div[1]/div/div/section[2]/div[1]/div/div[1]/div[1]/h2")
    private WebElement paymentTextEle;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div/div[1]/div/div[2]/div/aside/div/section/div/section/div[2]/div[5]/div[2]/div/div/span")
    private WebElement taxes;

    @FindBy(xpath = "//*[@id=\"tipping_list-tipping_list_options-collapsible\"]/div/div/div/div[1]/div/div")
    private WebElement tipButtonsEle;

    @FindBy(xpath = "//strong[@class='_19gi7yt0 _19gi7ytr _1fragemp5 _19gi7yt1 notranslate']")
    private WebElement totalAmountEle;

    @FindBy(id = "TipsInput")
    private WebElement customTipInput;

    @FindBy(xpath = "//*[@id=\"tipping_list-tipping_list_options-collapsible\"]/div/div/div/div[2]/div/button")
    private WebElement updateTipBtn;

    @FindBy(xpath = "//*[@id=\"basic\"]/div/div[2]/label")
    private WebElement codBtn;

    @FindBy(xpath = "//*[@id=\"pay-button-container\"]/div/div/button")
    private WebElement completeOrderBtn;

    @FindBy(xpath = "//*[@id=\"checkout-main\"]/div/div/div[2]/div/div[1]/section[1]/div[1]/h2")
    private WebElement confirmationMessage;

    public String getPaymentText(){
        return webActions.getText(paymentTextEle);
    }

    public BillingPage(WebDriver webDriver) {
        super(webDriver);
    }


    public double getSubTotal(){
        String value=webActions.getText(subTotal);
        String numericStr = value.replaceAll("[^0-9.]", "");
        double subTotal = Double.parseDouble(numericStr);
        return subTotal;
    }

    public double valueForTip(){
        double subTotal=getSubTotal();
        String value=webActions.getText(offerDiscount);
        String numericStr = value.replaceAll("[^0-9.]", "");
        double amount = Double.parseDouble(numericStr);
        double amountForTip=subTotal-amount;
        return amountForTip;
    }

    @FindBy(xpath = "//*[@id=\"tipping_list-tipping_list_options-collapsible\"]/div/div/div/div[1]/div/div/button[2]")
    private WebElement five;
    public double tipAmount() throws InterruptedException {
        double tipamount = 0;
        buttonActions.click(five);

        WebDriverWait webDriverWait=new WebDriverWait(webDriver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.visibilityOf(taxes));

        WebElement buttonWithAriaPressedTrue = null;
        List<WebElement> allButtons = tipButtonsEle.findElements(By.tagName("button"));
        for (WebElement button : allButtons) {
            if ("true".equals(button.getAttribute("aria-pressed"))) {
                buttonWithAriaPressedTrue = button;
                break;
            }
        }

        if (buttonWithAriaPressedTrue != null) {
            String buttonText = buttonWithAriaPressedTrue.getText();
            if (!buttonText.contains("None")) {
                String percentageStr = buttonText.substring(0, buttonText.indexOf("%"));
                double percentage = Double.parseDouble(percentageStr);
                tipamount = (percentage / 100) * valueForTip();
            }else{
                tipamount=0+valueForTip();
            }
        }
//        System.out.println(tipamount);

//        textBox.type(customTipInput,10);
//        buttonActions.click(updateTipBtn);
//        String text = webActions.getText(customTipInput);
//        System.out.println(text);
//
//        if (text != null && !text.isEmpty()) {
//            try {
//                double customTipAmount = Double.parseDouble(text);
//                if (customTipAmount >= 0) {
//                    tipamount = customTipAmount;
//                } else {
//                    System.err.println("Custom tip amount cannot be negative: " + customTipAmount);
//                }
//            } catch (NumberFormatException e) {
//                System.err.println("Invalid custom tip amount: " + text);
//            }
//        }
//
//        System.out.println(tipamount);
        taxValue();

        return tipamount;
    }

    public double getTipDisplayed() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        WebElement tipElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div/div/div[1]/div/div[2]/div/aside/div/section/div/section/div[2]/div[6]/div[2]/span")));

        String value = webActions.getText(tipElement);
        String numericStr = value.replaceAll("[^0-9.]", "");
        double tipDisplayed = Double.parseDouble(numericStr);

        return tipDisplayed;
    }
    public double taxValue(){
        String value=webActions.getText(taxes);
        String numericStr = value.replaceAll("[^0-9.]", "");
        double taxAmount = Double.parseDouble(numericStr);
        return taxAmount;
    }
    public double offer(){
        String value=webActions.getText(offerDiscount);
        String numericStr = value.replaceAll("[^0-9.]", "");
        double offer = Double.parseDouble(numericStr);
        return offer;
    }

    public double totalAmount() throws InterruptedException {
        Thread.sleep(3000);
        double totalAmount=0;
//        System.out.println(getSubTotal());
        totalAmount=getSubTotal()+tipAmount()+taxValue()-offer();
        return Math.round(totalAmount * 100.0) / 100.0;
    }

    public double autoTotalAmount(){
        String value=webActions.getText(totalAmountEle);
        String numericStr = value.replaceAll("[^0-9.]", "");
        double total = Double.parseDouble(numericStr);
        return total;
    }

    public void selectPayment(){
        //for credit card

        //cod
        buttonActions.click(codBtn);
    }

    public void completeOrder(){
        buttonActions.click(completeOrderBtn);
    }

    public String getConfirmationMessage() {
        return webActions.getText(confirmationMessage);
    }
}
