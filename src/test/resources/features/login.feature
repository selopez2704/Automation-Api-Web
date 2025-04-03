@SouceDemo
Feature: Login

  Scenario: Validate Valid User Login
    Given I Login with valid credentials
    Then I should be able to see the products page

  Scenario: Validate locked User Login
    Given I Login with locked credentials
    Then The login should fails

