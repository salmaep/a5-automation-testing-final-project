Feature: Get User API Tests

  Scenario: Forbidden - App ID Missing
    Given the app-id is ""
    When I send a GET request to "user/60d0fe4f5311236168a109ca"
    Then the response status code should be 403
    And the response body should have error "APP_ID_MISSING"

  Scenario: Forbidden - App ID Not Exist
    Given the app-id is "662e2e44bb70a7c4a12593f5"
    When I send a GET request to "user/60d0fe4f5311236168a109ca"
    Then the response status code should be 403
    And the response body should have error "APP_ID_NOT_EXIST"

  Scenario: Bad Request - Invalid ID
    Given the app-id is "6635f6c123256272eaba3b31"
    When I send a GET request to "user/test123"
    Then the response status code should be 400
    And the response body should have error "PARAMS_NOT_VALID"

  Scenario: Get Users Success
    Given the app-id is "6635f6c123256272eaba3b31"
    When I send a GET request to "user"
    Then the response status code should be 200
    And the response body should have data with size 20

  Scenario: Bad Request - Invalid ID Format
    Given the app-id is "6635f6c123256272eaba3b31"
    When I send a GET request to "user/test123"
    Then the response status code should be 400
    And the response body should have error "PARAMS_NOT_VALID"
