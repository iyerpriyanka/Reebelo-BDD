package com.au.reebelo.ui.automation.stepDefinition;


import com.au.reebelo.ui.automation.base.BaseTest;
import com.au.reebelo.ui.automation.enums.SupportedBrowsers;
import com.au.reebelo.ui.automation.pageObject.*;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Checkout extends BaseTest {
    HomeScreenPageObject homeScreen = new HomeScreenPageObject();
    SearchResultPageObject searchResult = new SearchResultPageObject();
    ProductDescriptionPageObject productDescription = new ProductDescriptionPageObject();
    MyCartPageObject cart = new MyCartPageObject();
    CheckoutInformationPageObject checkoutInformation = new CheckoutInformationPageObject();

    @When("Search for Product {string}")
    public void Search_for_Product(String product) {
        homeScreen.searchProducts(product);
        Assert.assertTrue(searchResult.getSearchHeading().contains(product));
    }

    @When("Validate Product Result {string} per page")
    public void Validate_Product_Result_per_page(String productResult) {
        Assert.assertEquals(Integer.parseInt(productResult), searchResult.getSearchResultInAPage());
    }

    @When("click on First Product, validate image, warranty section and click on add to cart")
    public void click_First_Product_validate_image_warranty_click_add_to_cart() {
        searchResult.clickOnFirstResult();
        Assert.assertTrue(productDescription.isProductImageDisplayed());
        Assert.assertTrue(productDescription.isProductWarrantyPriceDisplayed());
        Assert.assertTrue(productDescription.getProductMonthExtension().contains("24"));
        productDescription.clickOnAddToCart();
    }

    @When("validate total number of products {string} in cart and accessory section, click on checkout")
    public void validate_total_number_of_products_in_cart_and_accessory_section_click_on_checkout(String noOfProducts) {
        Assert.assertTrue(cart.getTitle().contains("Your Shopping Cart"));
        Assert.assertEquals(Integer.parseInt(noOfProducts), cart.getItemsInCart());
        Assert.assertTrue(cart.isAccessorySectionDisplayed());
        Assert.assertEquals("Customers who bought this also purchased", cart.getAccessoryHeader());
        cart.clickOnCheckout();
    }

    @Then("User details page should be displayed {string}")
    public void User_details_page_should_be_displayed(String expected) {
        Assert.assertEquals(expected, checkoutInformation.getTitle());
        closeBrowser();
    }
}
