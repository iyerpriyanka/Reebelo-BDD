package com.au.reebelo.ui.automation.pageObject;


import com.au.reebelo.ui.automation.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;

public class AccountCreationPageObject extends BaseTest {

    String screenshotFileName = "accountCreation";

    By firstName = By.id("RegisterForm-FirstName");
    By lastname = By.id("RegisterForm-LastName");
    By email = By.id("RegisterForm-email");
    By password = By.id("RegisterForm-password");
    By submit = By.cssSelector("input[type='submit']");
    By errorOfFields = By.cssSelector("div.form-message.form-message--error");

    public AccountCreationPageObject() {
        PageFactory.initElements(driver, this);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void setFirstName(String firstName) {
        driver.findElement(this.firstName).sendKeys(firstName);
    }

    public void setLastname(String lastName) {
        driver.findElement(this.lastname).sendKeys(lastName);
    }

    public void setEmail(String email) {
        driver.findElement(this.email).sendKeys(email);
    }

    public void setPassword(String password) {
        driver.findElement(this.password).sendKeys(password);
    }

    public void clickSubmit() {
        driver.findElement(submit).click();
    }

    public Boolean isErrorDisplayed() {
        try {
            driver.findElement(errorOfFields).isDisplayed();
            takeScreenshot(screenshotFileName);
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    public String getErrorMessage() {
        return driver.findElement(errorOfFields).getText();
    }

    public void createAccount(String firstName, String lastName, String email, String password) {

        setFirstName(firstName);
        setLastname(lastName);
        setEmail(email);
        setPassword(password);
        clickSubmit();
    }

    public String checkDisplayError() {

        if (isErrorDisplayed()){
            return getErrorMessage();
        }
        return "Success";
    }

}
