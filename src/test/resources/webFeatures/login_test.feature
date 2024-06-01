Feature: Login
  This feature deal with all the login test case

  # Scenario test case 0.0.1
  Scenario Outline: Successful Login
    Given I am on the login page
    When I enter "<username>" and "<password>"
    And I click the login button
    Then I should be redirected to the dashboard page

    Examples:
      | username       | password      |
      | standard_user  | secret_sauce  |

  # Scenario test case 0.0.2
  Scenario: Negative Login - User does not input username and password
    Given I am on the login page
    When I do not enter username and password
    And I click the login button
    Then I should see a username is required error message

  # Scenario test case 0.0.3
  Scenario: Negative Login - User enters registered username with incorrect password
    Given I am on the login page
    When I enter registered username with incorrect password
    And I click the login button
    Then I should see an error message for incorrect password