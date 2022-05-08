Feature: Test Product URLs

  Scenario Outline: Test Product URLs of Home Page
    Given Open chrome browser and redirect to homePage
    When Get all Product Urls
    Then Check Url against status code "<StatusCode>"

    Examples:
      | StatusCode |
      | 200        |