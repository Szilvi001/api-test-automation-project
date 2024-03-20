Feature: Update request on the json-server API

  Scenario: Update a post to the API
    Given the PUT request is prepared
    When I send a PUT request to "/posts/1"
    Then the response status code should be 200

  Scenario: Create a post to the API with empty request body
    Given the PUT request is prepared with empty request body
    When I send a PUT request to "/posts/1"
    Then the response status code should be 200