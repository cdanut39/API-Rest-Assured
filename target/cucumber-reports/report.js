$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("AddBook.feature");
formatter.feature({
  "line": 1,
  "name": "POST",
  "description": "",
  "id": "post",
  "keyword": "Feature"
});
formatter.before({
  "duration": 214329927,
  "status": "passed"
});
formatter.scenario({
  "line": 3,
  "name": "Add a new book in library by filling all mandatory fields with valid data",
  "description": "",
  "id": "post;add-a-new-book-in-library-by-filling-all-mandatory-fields-with-valid-data",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "User sets the following headers",
  "rows": [
    {
      "cells": [
        "Key",
        "Value"
      ],
      "line": 5
    },
    {
      "cells": [
        "Content-Type",
        "application/json"
      ],
      "line": 6
    }
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "User sets the following payload",
  "rows": [
    {
      "cells": [
        "name",
        "isbn",
        "aisle",
        "author"
      ],
      "line": 8
    },
    {
      "cells": [
        "Automated Software Testing",
        "1",
        "1",
        "John Paul"
      ],
      "line": 9
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "User sends POST request",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "Body should contain the following message \"successfully added\" and status code 200",
  "keyword": "Then "
});
formatter.match({
  "location": "POSTRequestStepDef.user_uses_the_following_headers(DataTable)"
});
formatter.result({
  "duration": 162632064,
  "status": "passed"
});
formatter.match({
  "location": "POSTRequestStepDef.user_sets_the_following_payload(DataTable)"
});
formatter.result({
  "duration": 62995211,
  "status": "passed"
});
formatter.match({
  "location": "POSTRequestStepDef.user_sends_POST_request()"
});
formatter.result({
  "duration": 1102715462,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "successfully added",
      "offset": 43
    },
    {
      "val": "200",
      "offset": 79
    }
  ],
  "location": "POSTRequestStepDef.body_should_contain_the_following_message_and_status_code(String,int)"
});
formatter.result({
  "duration": 311437428,
  "status": "passed"
});
formatter.uri("GetBookInfo.feature");
formatter.feature({
  "line": 1,
  "name": "GET",
  "description": "",
  "id": "get",
  "keyword": "Feature"
});
formatter.before({
  "duration": 30047,
  "status": "passed"
});
formatter.scenario({
  "line": 3,
  "name": "Get a book by id",
  "description": "",
  "id": "get;get-a-book-by-id",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "User wants to get a book by submitting valid id",
  "keyword": "When "
});
formatter.step({
  "line": 5,
  "name": "Status code should be 200 and isbn should be available",
  "keyword": "Then "
});
formatter.match({
  "location": "GETRequestStepDef.user_wants_to_get_a_book_by_submitting_valid_id()"
});
formatter.result({
  "duration": 499782460,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 22
    }
  ],
  "location": "GETRequestStepDef.status_code_should_be_and_isbn_should_be_available(int)"
});
formatter.result({
  "duration": 16254794,
  "status": "passed"
});
formatter.uri("RemoveBook.feature");
formatter.feature({
  "line": 1,
  "name": "DELETE",
  "description": "",
  "id": "delete",
  "keyword": "Feature"
});
formatter.before({
  "duration": 30948,
  "status": "passed"
});
formatter.scenario({
  "line": 3,
  "name": "Delete a book by id",
  "description": "",
  "id": "delete;delete-a-book-by-id",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "User wants to delete a book by submitting valid id",
  "keyword": "When "
});
formatter.step({
  "line": 5,
  "name": "Response with status code 200 and message \"book is successfully deleted\" should be visible",
  "keyword": "Then "
});
formatter.match({
  "location": "DELETERequestStepDef.user_wants_to_delete_a_book_by_submitting_valid_id()"
});
formatter.result({
  "duration": 495613147,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 26
    },
    {
      "val": "book is successfully deleted",
      "offset": 43
    }
  ],
  "location": "DELETERequestStepDef.response_with_status_code_and_message(int,String)"
});
formatter.result({
  "duration": 12389856,
  "status": "passed"
});
});