Feature: Delete User API Tests

  Scenario: Forbidden - App ID Missing
    Given the app-id is ""
    When I send a DELETE request to "user/60d0fe4f5311236168a109ca"
    Then the response status code should be 403
    And the response body should have error "APP_ID_MISSING"

  Scenario: Forbidden - App ID Not Exist
    Given the app-id is "662e2e44bb70a7c4a12593f5"
    When I send a DELETE request to "user/60d0fe4f5311236168a109ca"
    Then the response status code should be 403
    And the response body should have error "APP_ID_NOT_EXIST"

  Scenario: Delete User Success
    Given the app-id is "663712711bd9c51b097d1e19"
    When I send a DELETE request to "user/60d0fe4f5311236168a109ca"
    Then the response status code should be 200
    And the response body should have id "60d0fe4f5311236168a109ca"

  Scenario: Resource Not Found
    Given the app-id is "6635f6c123256272eaba3b31"
    When I send a DELETE request to "user/60d0fe4f5311236168a109ca"
    Then the response status code should be 404
    And the response body should have error "RESOURCE_NOT_FOUND"

  Scenario: Path Not Found
    Given the app-id is "6635f6c123256272eaba3b31"
    When I send a DELETE request to ""
    Then the response status code should be 404
    And the response body should have error "PATH_NOT_FOUND"
