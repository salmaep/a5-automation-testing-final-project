Feature: Login
  This feature deals with all the login test cases

  # Scenario test case 0.0.1
  Scenario Outline: Successful Login
    Given the user is on the login page
    When the user enters "<username>" and "<password>"
    And the user clicks the login button
    Then the user should be redirected to the dashboard page

    Examples:
      | username       | password      |
      | standard_user  | secret_sauce  |

  # Scenario test case 0.0.2
  Scenario: Negative Login - User does not input username and password
    Given the user is on the login page
    When the user does not enter username and password
    And the user clicks the login button
    Then the user should see a username is required error message

  # Scenario test case 0.0.3
  Scenario: Negative Login - User enters registered username with incorrect password
    Given the user is on the login page
    When the user enters registered username with incorrect password
    And the user clicks the login button
    Then the user should see an error message for incorrect password
