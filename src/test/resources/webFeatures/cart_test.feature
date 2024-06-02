Feature: Cart Page Testing

  # Scenario TC-03-02 Test User checks out with 'Sauce Labs Backpack' in cart
  Scenario: Test User checks out with 'Sauce Labs Backpack' in cart
    Given the user is logged in to the application with username "standard_user" and password "secret_sauce"
    And the user is on the Dashboard page
    And the user clicks on the 'Add to Cart' button for 'Sauce Labs Backpack'
    When the user clicks the "shopping cart" button on the "dashboard" page
    And the user is on the "cart" page
    And the system displays the cart page with 'Sauce Labs Backpack' listed
    And the user clicks the "checkout" button on the "cart" page
    Then the system displays the Checkout Information page with first name, last name, and zip&postal code fields

  # Scenario TC-03-03 Test User continues shopping with 'Sauce Labs Backpack' in cart
  Scenario: Test User continues shopping with 'Sauce Labs Backpack' in cart
    Given the user is logged in to the application with username "standard_user" and password "secret_sauce"
    And the user is on the Dashboard page
    And the user clicks on the 'Add to Cart' button for 'Sauce Labs Backpack'
    When the user clicks the "shopping cart" button on the "dashboard" page
    And the user is on the "cart" page
    And the user clicks the "continue shopping" button on the "cart" page
    Then the user is on the Dashboard page

  # Scenario TC-03-04 Test User clicks on Cart with no products in cart
  Scenario: Test User clicks on Cart with no products in cart
    Given the user is logged in to the application with username "standard_user" and password "secret_sauce"
    And the user is on the Dashboard page
    When the user clicks the "shopping cart" button on the "dashboard" page
    And the user is on the "cart" page
    Then the system displays the cart page with no products since no products have been added to the cart
