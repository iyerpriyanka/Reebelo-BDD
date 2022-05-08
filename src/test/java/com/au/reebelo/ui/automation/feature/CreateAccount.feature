Feature: Test Rebeelo Create My Account Page

  Scenario Outline: Test Create My Account Page with different set of values
    Given Open chrome browser and redirect to homePage
    When Click on Account and click on Create your account
    And Provide data for FirstName "<FirstName>" LastName "<LastName>" Email "<Email>" Password "<Password>" and click on create my account
    Then Validate with expected result "<Expected>"

    Examples:
      | FirstName | LastName | Email           | Password | Expected         |
      | Test      | Two      | test2@gmail.com | TestTwo2 | test@gmail.com   |
      | Test      |          | test@gmailcom   | TestTwo2 | Email is invalid |