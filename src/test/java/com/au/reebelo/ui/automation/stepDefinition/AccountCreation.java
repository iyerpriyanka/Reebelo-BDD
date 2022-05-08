package com.au.reebelo.ui.automation.stepDefinition;


import com.au.reebelo.ui.automation.base.BaseTest;
import com.au.reebelo.ui.automation.enums.SupportedBrowsers;
import com.au.reebelo.ui.automation.pageObject.AccountCreationPageObject;
import com.au.reebelo.ui.automation.pageObject.HomeScreenPageObject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AccountCreation extends BaseTest {

    HomeScreenPageObject homeScreen = new HomeScreenPageObject();
    AccountCreationPageObject accountCreation = new AccountCreationPageObject();

    @Given("Open chrome browser and redirect to homePage")
    public void Open_chrome_browser_and_redirect_to_homePage() {
        SupportedBrowsers sb = SupportedBrowsers.getBrowser("chrome");
        if (sb == null)
            throw new RuntimeException(String.format("%s defined browser not supported.", "Chrome"));
        BaseTest.initialization(sb);
        Assert.assertTrue(homeScreen.getTitle().contains("Reebelo Australia"));
        Assert.assertTrue(homeScreen.isLogoDisplayed());
    }

    @When("Click on Account and click on Create your account")
    public void Click_on_Account_and_click_on_Create_your_account() {
        homeScreen.clickCreateAccount();
        Assert.assertTrue(accountCreation.getTitle().contains("Create Account"));
    }

    @When("Provide data for FirstName {string} LastName {string} Email {string} Password {string} and click on create my account")
    public void Provide_data_for_FirstName_LastName_Email_Password_and_click_on_create_my_account(String firstName, String lastName, String email, String password) {
        accountCreation.createAccount(firstName, lastName, email, password);
    }

    @Then("Validate with expected result {string}")
    public void Validate_with_expected_result(String expected) {
        System.out.println(accountCreation.checkDisplayError());
        Assert.assertTrue(accountCreation.checkDisplayError().contains(expected));
        closeBrowser();
    }
}
