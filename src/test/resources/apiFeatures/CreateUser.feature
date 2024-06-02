Feature: Create Data

  Scenario: Fill in all fields with all valid data
    Given the app-id is "662e2649bb70a7601b259395"
    And the Content-Type is "application/json"
    When I send a POST request to "user/create" with the following body:
      """
      {
          "title": "mr",
          "firstName": "John",
          "lastName": "Doe",
          "picture": "https://randomuser.me/api/portraits/men/75.jpg",
          "gender": "male",
          "email": "john_doe@gmail.com",
          "dateOfBirth": "1990-01-01T00:00:00.000Z",
          "phone": "123456789",
          "location": {
              "street": "123 Main Street",
              "city": "Anytown",
              "state": "NY",
              "country": "USA",
              "timezone": "-5:00"
          }
      }
      """
    Then the response status code should be 200
    And the response body should have a valid id
    And the response body should contain the following:
      """
      {
          "title": "mr",
          "firstName": "John",
          "lastName": "Doe",
          "picture": "https://randomuser.me/api/portraits/men/75.jpg",
          "gender": "male",
          "email": "john_doe@gmail.com",
          "dateOfBirth": "1990-01-01T00:00:00.000Z",
          "phone": "123456789",
          "location": {
              "street": "123 Main Street",
              "city": "Anytown",
              "state": "NY",
              "country": "USA",
              "timezone": "-5:00"
          }
      }
      """
    And the response body should have valid registerDate and updatedDate

  Scenario: just required
    Given the app-id is "662e2649bb70a7601b259395"
    And the Content-Type is "application/json"
    When I send a POST request to "user/create" with the following body:
      """
      {
          "firstName": "John",
          "lastName": "Doe",
          "email": "john_doe_j@gmail.com"
      }
      """
    Then the response status code should be 200
    And the response body should have a valid id
    And the response body should have valid registerDate and updatedDate
    And the response body should contain the following:
      """
      {
          "firstName": "John",
          "lastName": "Doe",
          "email": "john_doe_j@gmail.com"
      }
      """
    And the response body should have valid registerDate and updatedDate


  Scenario: Fill in all fields with data that already exists in the system
    Given the app-id is "662e2649bb70a7601b259395"
    And the Content-Type is "application/json"
    When I send a POST request to "user/create" with the following body:
      """
      {
          "title": "mr",
          "firstName": "John",
          "lastName": "Doe",
          "picture": "https://randomuser.me/api/portraits/men/75.jpg",
          "gender": "male",
          "email": "john_doe@gmail.com",
          "dateOfBirth": "1990-01-01T00:00:00.000Z",
          "phone": "123456789",
          "location": {
              "street": "123 Main Street",
              "city": "Anytown",
              "state": "NY",
              "country": "USA",
              "timezone": "-5:00"
          }
      }
      """
    Then the response status code should be 400
    And the response body should have error "BODY_NOT_VALID"

  Scenario: Fill in all fields except title filled with empty string
    Given the app-id is "662e2649bb70a7601b259395"
    And the Content-Type is "application/json"
    When I send a POST request to "user/create" with the following body:
      """
      {
          "title": "",
          "firstName": "Alice",
          "lastName": "Smith",
          "picture": "https://randomuser.me/api/portraits/women/75.jpg",
          "gender": "female",
          "email": "alice_m_ith@gmail.com",
          "dateOfBirth": "1988-05-15T00:00:00.000Z",
          "phone": "987654321",
          "location": {
              "street": "456 Elm Street",
              "city": "Sometown",
              "state": "CA",
              "country": "USA",
              "timezone": "-8:00"
          }
      }
      """
    Then the response status code should be 200
    And the response body should have empty title
    And the response body should contain the following:
      """
      {
          "title": "",
          "firstName": "Alice",
          "lastName": "Smith",
          "picture": "https://randomuser.me/api/portraits/women/75.jpg",
          "gender": "female",
          "email": "alice_m_ith@gmail.com",
          "dateOfBirth": "1988-05-15T00:00:00.000Z",
          "phone": "987654321",
          "location": {
              "street": "456 Elm Street",
              "city": "Sometown",
              "state": "CA",
              "country": "USA",
              "timezone": "-8:00"
          }
      }
      """
    And the response body should have valid registerDate and updatedDate

  Scenario: Fill in all fields correctly, but dateOfBirth is set to a date after today
    Given the app-id is "662e2649bb70a7601b259395"
    And the Content-Type is "application/json"
    When I send a POST request to "user/create" with the following body:
      """
      {
          "title": "mrs",
          "firstName": "Alice",
          "lastName": "Smith",
          "picture": "https://randomuser.me/api/portraits/women/75.jpg",
          "gender": "female",
          "email": "alice.smith@gmail.com",
          "dateOfBirth": "2025-05-15T00:00:00.000Z",
          "phone": "987654321",
          "location": {
              "street": "456 Elm Street",
              "city": "Sometown",
              "state": "CA",
              "country": "USA",
              "timezone": "-8:00"
          }
      }
      """
    Then the response status code should be 400
    And the response body should have error "BODY_NOT_VALID"
