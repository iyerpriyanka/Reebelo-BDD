package com.au.reebelo.ui.automation.stepDefinition;


import com.au.reebelo.ui.automation.url.HomeScreenProduct;
import com.au.reebelo.ui.automation.base.BaseTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ProductUrl extends BaseTest {

    HomeScreenProduct product = new HomeScreenProduct();

    @When("Get all Product Urls")
    public void Get_all_Product_Url() {
        product.getProductUrl();
    }

    @Then("Check Url against status code {string}")
    public void Check_Url_against_status_code(String statusCode) {
        Assert.assertTrue(product.statusCodeMatcher(Integer.parseInt(statusCode)));
        closeBrowser();
    }
}
