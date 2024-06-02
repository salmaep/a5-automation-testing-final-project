Feature: Dashboard Page Testing

  # Scenario TC-02-02 Test click on product details that is 'Sauce Labs Backpack'
  Scenario: Test click on product details that is 'Sauce Labs Backpack'
    Given the user is logged in to the application with username "standard_user" and password "secret_sauce"
    And the user is on the Dashboard page
    When the user clicks on the 'Sauce Labs Backpack' product image
    Then the product detail page is displayed with the details of 'Sauce Labs Backpack'

  # Scenario TC-02-03 Test user adds 'Sauce Labs Backpack' to cart
  Scenario: Test user adds 'Sauce Labs Backpack' to cart
    Given the user is logged in to the application with username "standard_user" and password "secret_sauce"
    And the user is on the Dashboard page
    And the 'Add to Cart' button is displayed for 'Sauce Labs Backpack'
    When the user clicks on the 'Add to Cart' button for 'Sauce Labs Backpack'
    Then the button changes to 'Remove'
    And 'Sauce Labs Backpack' is added to the cart
    And the cart icon shows the correct number of items

  # Scenario TC-02-04 Test user removes 'Sauce Labs Backpack' from cart
  Scenario: Test user removes 'Sauce Labs Backpack' from cart
    Given the user is logged in to the application with username "standard_user" and password "secret_sauce"
    And the user is on the Dashboard page
    And the 'Add to Cart' button is displayed for 'Sauce Labs Backpack'
    And the user clicks on the 'Add to Cart' button for 'Sauce Labs Backpack'
    And the 'Remove' button is displayed for 'Sauce Labs Backpack'
    When the user clicks on the 'Remove' button for 'Sauce Labs Backpack'
    Then the button changes to 'Add to Cart'
    And 'Sauce Labs Backpack' is removed from the cart
    And the cart icon doesn't have an item