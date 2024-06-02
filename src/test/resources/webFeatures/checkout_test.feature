Feature: Checkout Feature Testing

  # Scenario TC-04-01 Test cancel checkout without fills all fields in checkout information page
  Scenario: Test cancel checkout without fills all fields in checkout information page
    Given the user is logged in to the application with username "standard_user" and password "secret_sauce"
    And the user is on the Dashboard page
    And the user clicks on the 'Add to Cart' button for 'Sauce Labs Backpack'
    When the user clicks the "shopping cart" button on the "dashboard" page
    And the user is on the "cart" page
    And the user clicks the "checkout" button on the "cart" page
    When the user is on the "checkout information" page
    And the user does not fill in all fields on the checkout page
    And the user clicks the "cancel" button on the "checkout information" page
    Then the user should be redirected to the "cart" page

  # Scenario TC-04-02 Test checkout with fills all fields in checkout information page
  Scenario: Test cancel checkout without fills all field in checkout information page
    Given the user is logged in to the application with username "standard_user" and password "secret_sauce"
    And the user is on the Dashboard page
    And the user clicks on the 'Add to Cart' button for 'Sauce Labs Backpack'
    When the user clicks the "shopping cart" button on the "dashboard" page
    And the user is on the "cart" page
    And the user clicks the "checkout" button on the "cart" page
    And the user is on the "checkout information" page
    And the user enter "John" in the First Name field
    And the user enter "Doe" in the Last Name field
    And the user enter "40212" in the Postal Code field
    And the user clicks the "continue" button on the "checkout information" page
    Then the user should be redirected to the "checkout overview" page
    And the user should see information checkout about "cart quantity" is "1"
    And the user should see information checkout about "items name" is "Sauce Labs Backpack"
    And the user should see information checkout about "payment information" is "SauceCard #31337"
    And the user should see information checkout about "shipping information" is "Free Pony Express Delivery!"
    And the user should see information checkout about "price total" is "Total: $32.39"
