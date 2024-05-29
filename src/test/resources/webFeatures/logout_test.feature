Feature: Logout
  This feature deals with the logout functionality

  # Scenario test case 0.1.1
  Scenario: Positive Logout
    Given the user is logged in to the application with username "standard_user" and password "secret_sauce"
    And the user is on the dashboard page
    When the user clicks the menu icon on the top left corner of the dashboard
    And the user clicks the Logout menu
    Then the user should be redirected to the login page