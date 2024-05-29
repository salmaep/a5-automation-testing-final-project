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
  Scenario:Negative Login - Attempting to login with invalid credentials
    Given I am on the login page
    When I enter invalid username and password
    And I click the login button
    Then I should see an invalid username or password error message

  # Scenario test case 0.0.3
  Scenario: Negative Login - User does not input username and password
    Given I am on the login page
    When I do not enter username and password
    And I click the login button
    Then I should see a username is required error message

  # Scenario test case 0.0.4
  Scenario: Negative Login - User enters registered username with incorrect password
    Given I am on the login page
    When I enter registered username with incorrect password
    And I click the login button
    Then I should see an error message for incorrect password

  # Scenario test case 0.0.5
  Scenario Outline: Negative Login - Valid Username and Empty Password
    Given I am on the login page
    When I enter "<username>" as username
    And I leave the password field empty
    And I click the login button
    Then I should see the error message "You need Password!"

    Examples:
      | username        |
      | username1       |

  # Scenario test case 0.0.6
  Scenario Outline: Negative Login - Invalid Username and Valid Password
    Given I am on the login page
    When I enter "<username>" and "<password>"
    And I click the login button
    Then I should see the error message "Username  and password do not match any user in  this service!"

    Examples:
      | username    | password      |
      | username1   | secret_sauce  |

  # Scenario test case 0.0.7
  Scenario Outline: Negative Login - Empty Username and Valid Password
    Given I am on the login page
    When I leave the username field empty
    And I enter "<password>" as password
    And I click the login button
    Then I should see the error message "You need Username!"

    Examples:
      | password      |
      | password551   |

  # Scenario test case 0.0.8
  Scenario Outline: Negative Login - Invalid Username and Empty Password
    Given I am on the login page
    When I enter "<username>" as username
    And I leave the password field empty
    And I click the login button
    Then I should see the error message "You need Password!"

    Examples:
      | username       |
      | standard       |

  # Scenario test case 0.0.9
  Scenario Outline: Negative Login - Empty Username and Invalid Password
    Given I am on the login page
    When I leave the username field empty
    And I enter "<password>" as password
    And I click the login button
    Then I should see the error message "You need Username!"

    Examples:
      | password         |
      | standarduser321  |
