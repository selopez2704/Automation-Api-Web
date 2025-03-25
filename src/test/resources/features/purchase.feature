@SouceDemo

Feature: Purchase

#  @this
  Scenario: Verify that the user can purchase the cheapest product available in the store
    Given I Login with valid credentials
    And I should be able to see the products page
    And I sort the products from low to high price
    And I go to the cart
    And I go to checkout personal information
    And I fill the Your Information form
    And I go to checkout overview
    And I go to checkout complete
    Then The checkout complete page should be correctly displayed