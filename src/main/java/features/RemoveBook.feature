Feature: DELETE

  Scenario: Delete a book by id
    When User wants to delete a book by submitting valid id
    Then Response with status code 200 and message "book is successfully deleted" should be visible