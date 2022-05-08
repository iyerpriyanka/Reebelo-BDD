package com.au.reebelo.ui.automation.pageObject;


import com.au.reebelo.ui.automation.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class HomeScreenPageObject extends BaseTest {

    By searchTextBox = By.id("bc-sf-search-box-2");
    By reebeloLogo = By.cssSelector("img.header__logo-image.svg.ls-is-cached");
    By account = By.xpath("//span[contains(text(),'Account')]//preceding-sibling::a");
    By iPhone = By.xpath("//a[text()='iPhones']");
    By createAccount = By.xpath("//a[contains(text(),'Create your account')]");
    By allProductUrls = By.cssSelector("div.product-list>div.flickity-viewport>div.flickity-slider>div>a");


    public HomeScreenPageObject() {
        PageFactory.initElements(driver, this);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public boolean isLogoDisplayed() {
        return driver.findElement(reebeloLogo).isDisplayed();
    }

    public void clickAccountLink() {
        driver.findElement(account).click();
    }

    public void clickCreateAccount() {
        clickAccountLink();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(createAccount)));
        driver.findElement(createAccount).click();
    }

    public void searchProducts(String searchValue) {
        driver.findElement(searchTextBox).sendKeys(searchValue);
        driver.findElement(searchTextBox).sendKeys(Keys.RETURN);
    }

    public List<String> getProductUrls() {
        List<WebElement> elements = driver.findElements(allProductUrls);
        List<String> allUrls = new ArrayList<>();
        for (WebElement url : elements) {
            allUrls.add(url.getAttribute("href"));
        }
        return allUrls;
    }

}
