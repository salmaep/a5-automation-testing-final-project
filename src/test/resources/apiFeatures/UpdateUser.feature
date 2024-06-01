Feature: Update Field User

  #  Scenario update valid field title - TC-03-4
  Scenario: Update valid field title user
    Given the app-id is "662e2649bb70a7601b259395"
    And the Content-Type is "application/json"
    When I send a PUT request to "user/662e28f41846fb66ccd50ad7"
    And I update the user "title" to "mr"
    Then the response status code should be 200
    And the "title" should be "mr"

  #  Scenario update valid field first name - TC-03-10
  Scenario: Update valid field first name user
    Given the app-id is "662e2649bb70a7601b259395"
    And the Content-Type is "application/json"
    When I send a PUT request to "user/662e28f41846fb66ccd50ad7"
    And I update the user "firstName" to "Salma"
    Then the response status code should be 200
    And the "firstName" should be "Salma"

  #  Scenario update valid field last name - TC-03-11
  Scenario: Update valid field last name user
    Given the app-id is "662e2649bb70a7601b259395"
    And the Content-Type is "application/json"
    When I send a PUT request to "user/662e28f41846fb66ccd50ad7"
    And I update the user "lastName" to "Edyna"
    Then the response status code should be 200
    And the "lastName" should be "Edyna"

  #  Scenario update valid field picture - TC-03-12
  Scenario: Update valid field picture user
    Given the app-id is "662e2649bb70a7601b259395"
    And the Content-Type is "application/json"
    When I send a PUT request to "user/662e28f41846fb66ccd50ad7"
    And I update the user "picture" to "https://randomuser.me/api/portraits/women/59.jpg"
    Then the response status code should be 200
    And the "picture" should be "https://randomuser.me/api/portraits/women/59.jpg"

  #  Scenario update valid field gender - TC-03-15
  Scenario: Update valid field gender user
    Given the app-id is "662e2649bb70a7601b259395"
    And the Content-Type is "application/json"
    When I send a PUT request to "user/662e28f41846fb66ccd50ad7"
    And I update the user "gender" to "other"
    Then the response status code should be 200
    And the "gender" should be "other"