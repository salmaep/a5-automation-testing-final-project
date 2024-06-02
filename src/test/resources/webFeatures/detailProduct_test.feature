Feature: Detail Product

  # Scenario test case 0.0.1
  Scenario: Add 'Sauce Labs Backpack' to cart
    Given the user is on the product detail page for Sauce Labs Backpack
    When the user clicks the 'Add to cart' button
    Then the product should be added to the cart
    And the 'Add to cart' button should change to 'Remove'
    And the cart should show the correct number of items

  # Scenario test case 0.0.2
  Scenario: Remove 'Sauce Labs Backpack' from cart
    Given the user is on the product detail page for Sauce Labs Backpack
    And the product is already added to the cart
    When the user clicks the 'Remove' button
    Then the product should be removed from the cart
    And the 'Remove' button should change to 'Add to cart'
    And the cart should show the correct number of items

  # Scenario test case 0.0.3
  Scenario: Interaction with Cart Icon
    Given the user is on the product detail page for Sauce Labs Backpack
    When the user press the Cart Icon located at the top right corner
    Then the system displays the Cart page containing the products the user want to buy
