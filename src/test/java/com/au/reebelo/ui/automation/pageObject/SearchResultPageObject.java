package com.au.reebelo.ui.automation.pageObject;


import com.au.reebelo.ui.automation.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SearchResultPageObject extends BaseTest {
    By searchResults = By.cssSelector("div#bc-sf-filter-products>a");
    By selectFirstResult = By.cssSelector("div#bc-sf-filter-products>a:first-of-type");
    By searchHeading = By.cssSelector("div.collections-list-title-wrapper");

    public SearchResultPageObject() {
        PageFactory.initElements(driver, this);
    }

    public String getSearchHeading() {
        return driver.findElement(searchHeading).getText();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public int getSearchResultInAPage() {
        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(searchResults)));
        List<WebElement> result = driver.findElements(searchResults);
        return result.size();
    }

    public void clickOnFirstResult() {
        driver.findElement(selectFirstResult).click();
    }

}
