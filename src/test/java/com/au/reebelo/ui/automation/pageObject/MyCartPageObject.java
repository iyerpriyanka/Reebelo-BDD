package com.au.reebelo.ui.automation.pageObject;


import com.au.reebelo.ui.automation.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class MyCartPageObject extends BaseTest {

    By itemsInCheckOut = By.cssSelector("div.table-wrapper>table");
    By checkout = By.name("checkout");
    By accessorySection = By.cssSelector("div.product-list");
    By accessoryHeader = By.cssSelector("div.cart-accessories-section>h3");


    public MyCartPageObject() {
        PageFactory.initElements(driver, this);
    }

    public int getItemsInCart() {
        List<WebElement> items = driver.findElements(itemsInCheckOut);
        return items.size();
    }

    public String getTitle() {
        webDriverWait.until(ExpectedConditions.titleContains("Cart"));
        return driver.getTitle();
    }

    public void clickOnCheckout() {
        driver.findElement(checkout).click();
    }

    public boolean isAccessorySectionDisplayed() {
        return driver.findElement(accessorySection).isDisplayed();
    }

    public String getAccessoryHeader() {
        return driver.findElement(accessoryHeader).getText();
    }
}
