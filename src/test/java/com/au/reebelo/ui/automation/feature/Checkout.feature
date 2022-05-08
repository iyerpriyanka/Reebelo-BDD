Feature: Test flow till Checkout

  Scenario Outline: Test customer journey till checkout
    Given Open chrome browser and redirect to homePage
    When Search for Product "<Product>"
    And Validate Product Result "<ProductResult>" per page
    And click on First Product, validate image, warranty section and click on add to cart
    And validate total number of products "<NoOfProducts>" in cart and accessory section, click on checkout
    Then User details page should be displayed "<Expected>"

    Examples:
      | Product   | ProductResult | NoOfProducts | Expected                                   |
      | iphone 13 | 24            | 1            | Information - Reebelo Australia - Checkout |