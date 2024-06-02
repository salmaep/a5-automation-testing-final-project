Feature: End to End Web Testing
Description:
This feature file is to test the end-to-end flow of the application,
which includes the scenario where the user adds 1 product to the cart and proceeds 
to checkout starting from clicking the "Continue" button on the cart page.

  # Scenario : Test the end to end flow of the application
  Scenario: Test the end to end flow of the application
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
    And the user clicks the "finish" button on the "checkout overview" page
    Then the user should be redirected to the "checkout complete" page
    And the user should see the complete header message "Thank you for your order!"
    And the user should see the complete text message "Your order has been dispatched, and will arrive just as fast as the pony can get there!"
    When the user clicks the "back home" button on the "checkout complete" page
    Then the user should be redirected to the "dashboard" page
    And the user is on the "dashboard" page
    When the user clicks the menu icon on the top left corner of the dashboard
    And the user clicks the Logout menu
    Then the user should be redirected to the "login" page