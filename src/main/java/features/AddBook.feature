Feature: POST

  Scenario: Add a new book in library by filling all mandatory fields with valid data
    Given User sets the following headers
      | Key          | Value            |
      | Content-Type | application/json |
    And User sets the following payload
      | name                       | isbn | aisle | author    |
      | Automated Software Testing | 1    | 1     | John Paul |
    When User sends POST request
    Then Body should contain the following message "successfully added" and status code 200