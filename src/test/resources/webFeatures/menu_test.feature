Feature: Menu Page Testing

  # Scenario TC-04-01 Test menu All items in navigation bar menu
  Scenario: Test menu All items in navigation bar menu
    Given the user is logged in to the application with username "standard_user" and password "secret_sauce"
    And the user is on the dashboard page
    When the user clicks the menu icon on the top left corner of the dashboard
    And the user clicks the All Items menu
    Then the user should be redirected to the "inventory" page

  # Scenario TC-04-02 Test menu About in navigation bar menu
  Scenario: Test menu About in navigation bar menu
    Given the user is logged in to the application with username "standard_user" and password "secret_sauce"
    And the user is on the dashboard page
    When the user clicks the menu icon on the top left corner of the dashboard
    And the user clicks the About menu
    Then the user should be redirected to the "about" page

  # Scenario TC-04-03 Test menu Logout in navigation bar menu
  Scenario: Test menu Logout in navigation bar menu
    Given the user is logged in to the application with username "standard_user" and password "secret_sauce"
    And the user is on the dashboard page
    When the user clicks the menu icon on the top left corner of the dashboard
    And the user clicks the Logout menu
    Then the user should be redirected to the "login" page