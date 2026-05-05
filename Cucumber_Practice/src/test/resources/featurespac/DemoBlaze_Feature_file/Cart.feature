Feature: Category of the product

  Background:
    Given User is on the dashboard page
    When he clicks on the Laptop element in category
    Then the Laptop page should be loaded

  @Login
  Scenario: Tamilarasu 4-4-26 User can access the Product category to access the product categories

    And He sees the product MacBook Pro
    When Click on MacBook Pro
    Then MacBook Pro page is loaded
    And Click on add to cart

  @Login
  Scenario: Tamilarasu 4-4-26 User can access the Product category to access the product categories

    And He sees the product Sony vaio i5
    When Click on Sony vaio i5
    Then Sony vaio i5 page is loaded
    And Click on add to cart
