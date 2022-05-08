package com.au.reebelo.ui.automation.pageObject;


import com.au.reebelo.ui.automation.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class ProductDescriptionPageObject extends BaseTest {

    By addToCart = By.cssSelector("button#AddToCart.ajax-on.ajax-on-product.product-form__add-button");
    By buyItNow = By.cssSelector("button#BuyItNow.ajax-on.ajax-on-buy.product-form__buy-button");
    By productImage = By.cssSelector("img.product-gallery__image");
    By productWarrantyPrice = By.cssSelector("span.warranty-price");
    By productMonthExtension = By.cssSelector("div.add-months");


    public ProductDescriptionPageObject() {
        PageFactory.initElements(driver, this);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public boolean isProductWarrantyPriceDisplayed() {
        return driver.findElement(productWarrantyPrice).isDisplayed();
    }

    public boolean isProductImageDisplayed() {
        return driver.findElement(productImage).isDisplayed();
    }

    public String getProductMonthExtension() {
        return driver.findElement(productMonthExtension).getText();
    }

    public void clickOnAddToCart() {
        driver.findElement(addToCart).click();
    }

    public void clickOnBuyItNow() {
        driver.findElement(buyItNow).click();
    }
}
