Feature: Checkout Feature Testing

  # Scenario TC-04-01 Test cancel checkout without fill all field in checkout information page
  Scenario: Test cancel checkout without fill all field in checkout information page
    Given the user is logged in to the application with username "standard_user" and password "secret_sauce"
    And the user is on the "dashboard" page
    And the user clicks on the Add to Cart button for Sauce Labs Backpack
    When the user clicks the "shopping cart" button on the "dashboard" page
    And the user is on the "cart" page
    And the user clicks the "checkout" button on the "cart" page
    When the user is on the "checkout" page
    And the user does not fill in all fields on the checkout page
    And the user clicks the "cancel" button on the "cart" page
    Then the user should be redirected to the "cart" page