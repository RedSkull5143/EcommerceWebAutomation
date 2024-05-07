package com.capstone.webautomation.modals;

import com.capstone.webautomation.components.HeaderComponent;
import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FilterPriceModal extends HeaderComponent {

    @FindBy(xpath = "//*[@id=\"shopify-section-template--15328405684445__banner\"]/div/div/div/h1")
    private WebElement head;
    @FindBy(xpath = "//*[@id=\"Filter-Price-GTE\"]")
    public WebElement fromPrice;

    public WebElement getHead() {
        return head;
    }

    @FindBy(xpath = "//*[@id=\"Filter-Price-LTE\"]")
    private WebElement toPrice;

    @FindBy(xpath = "//*[@id=\"FacetsWrapperDesktop\"]/details[2]/div/div/span")
    private WebElement lblHighestPrice;

    @FindBy(xpath = "//*[@id=\"FacetsWrapperDesktop\"]/details[2]/div/div/facet-remove/a")
    private WebElement btnReset;

    public WebElement getFromPrice() {
        return fromPrice;
    }

    public WebElement getToPrice() {
        return toPrice;
    }

    public WebElement getLblHighestPrice() {
        return lblHighestPrice;
    }

    public WebElement getBtnReset() {
        return btnReset;
    }

    public FilterPriceModal(WebDriver webDriver) {
        super(webDriver);
    }
}
