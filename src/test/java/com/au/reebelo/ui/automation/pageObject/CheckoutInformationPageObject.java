package com.au.reebelo.ui.automation.pageObject;


import com.au.reebelo.ui.automation.base.BaseTest;
import org.openqa.selenium.support.PageFactory;

public class CheckoutInformationPageObject extends BaseTest {


    public CheckoutInformationPageObject() {
        PageFactory.initElements(driver, this);
    }

    public String getTitle() {
        return driver.getTitle();
    }
}
