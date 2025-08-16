Feature: Search product flipkart/Amazon
Scenario: Search product on flipkart and save the price
Given User launch firefox browser
Then  User open url "https://www.flipkart.com/"
Then  User search for product "Oneplus 13"
Then User click on one plus13 product
Then User get the price of the product
Then User save the price in excel sheet with the time
Then User close the browser

Scenario: Search Product on Amazon
Given User launch firefox browser
Then  User open url "https://www.amazon.com"
Then  User search for product "Oneplus 13"
Then User click on one plus13 product
Then User get the price of the product
Then User save the price in excel sheet with the time
Then User close the browser