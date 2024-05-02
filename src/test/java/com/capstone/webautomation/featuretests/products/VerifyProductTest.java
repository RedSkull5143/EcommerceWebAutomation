package com.capstone.webautomation.featuretests.products;

import com.capstone.webautomation.BaseTest;
import com.capstone.webautomation.actions.SearchContent;
import com.capstone.webautomation.actions.VerifySearch;
import com.capstone.webautomation.actions.ZoomImage;
import com.capstone.webautomation.components.SearchModal;
import com.capstone.webautomation.data.client.ProductDataClient;
import com.capstone.webautomation.models.ChoosedProduct;
import com.capstone.webautomation.models.Product;
import com.capstone.webautomation.pages.HomePage;
import com.capstone.webautomation.pages.ProductsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyProductTest extends BaseTest {

    @Test
    public void verifyProductInformationIsCorrect(){
        //arrange
        SearchContent searchContent=SearchContent.builder().build().init();
        HomePage homePage=new HomePage(getWebDriver());
        SearchModal searchModal = homePage.getHeader().openSearchModal();
        ProductDataClient productDataClient=new ProductDataClient();
        String name = productDataClient.getProduct().getName();

        //act
        ProductsPage productsPage = searchModal.searchResult(searchContent.getInput());
        WebElement productImage= getWebDriver().findElement(By.xpath("//*[@id=\"product-grid\"]/ul/li/div"));
        productImage.click();

        ChoosedProduct choosedProduct=new ChoosedProduct(getWebDriver());
        String productName = choosedProduct.getProductName();
        String sellerName=choosedProduct.getSellerName();
        String regularPrice=choosedProduct.getPrice();

        //assert
        Assert.assertTrue(productName.contains(name));
        Assert.assertTrue(sellerName.contains(sellerName));
        Assert.assertTrue(regularPrice.contains(regularPrice));
     }

     @Test(description = "Verify that clicking on the image zooms it to an enlarged view")
    public void userIsAbleToZoomImage(){
         SearchContent searchContent=SearchContent.builder().build().init();
         HomePage homePage=new HomePage(getWebDriver());
         SearchModal searchModal = homePage.getHeader().openSearchModal();
         ProductDataClient productDataClient=new ProductDataClient();

         //act
         ProductsPage productsPage = searchModal.searchResult(searchContent.getInput());
         WebElement productImage= getWebDriver().findElement(By.xpath("//*[@id=\"product-grid\"]/ul/li/div"));
         productImage.click();

         ZoomImage zoomImage=new ZoomImage(getWebDriver());
         zoomImage.zoomImageFunction();

         //assert
//         System.out.println(zoomImage.getZoomedHeight());
//         System.out.println(zoomImage.getOriginalHeight());
         Assert.assertTrue(zoomImage.getZoomedWidth()> zoomImage.getOriginalWidth());
     }
}
