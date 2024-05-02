package com.capstone.webautomation.modals;

import com.capstone.webautomation.components.HeaderComponent;
import com.capstone.webautomation.pages.SearchedProductPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchModal extends HeaderComponent {
    @FindBy(id = "Search-In-Modal")
    private WebElement inputBoxEle;
    public SearchModal(WebDriver webDriver) {
        super(webDriver);
    }

    public SearchedProductPage searchResult(String input){
        textBox.type(inputBoxEle,input);
        inputBoxEle.submit();
        return new SearchedProductPage(webDriver);
    }

}
