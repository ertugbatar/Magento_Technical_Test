@Smoke

Feature: Add products to cart and check cart total
  As a customer
  I want to add items to my cart
  So that I can purchase them


  Scenario: Add products to cart and check cart total
    Given I am on the homepage
    When I add "Gwyn Endurance Tee" to the cart with quanitiy "4"
    And I select "United Kingdom" as the shipping address
    Then the cart total should be "$92.00"
    When I update the quantity of "Gwyn Endurance Tee" to "3"
    And I add to quantity "1" "Gwyn Endurance Tee" to chart
    And I add again "Quest Lumaflex™ Band" to the cart with quantity "1"
    Then the latest cart total should be "$116.00"