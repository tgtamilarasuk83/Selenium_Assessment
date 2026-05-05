Feature: Category of the product

  Background:
    Given User is in the dashboard page .
    When he click on the Laptop element in categorie .
    Then the Laptiop page should be loaded

  @Category1
  Scenario: Tamilarasu 4-4-26 User can acess the Product category to acces the product categories
    And He see the product MacBook Pro
    When Click on MacBook Pro
    Then MacBook Pro page is loaded.

  @Category2
  Scenario: Tamilarasu 4-4-26 User can acess the Product category to acces the product categories
    And He see the product Sony vaio i5
    When Click on Sony vaio i5
    Then Sony vaio i5 page is loaded.