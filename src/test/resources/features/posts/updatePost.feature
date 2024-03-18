Feature: Update request on the json-server API

  Scenario: Update a post to the API
    Given the PUT request is prepared
    When I send a PUT request to "/posts/1"
    Then the response status code should be 201

  Scenario: Create a post to the API with empty request body
    Given the PUT request is prepared
    When I send a PUT request to "/posts/1"
    Then the response status code should be 201

  Scenario: Create a post to the API with invalid JSON schema
    Given the PUT request is prepared
    When I send a PUT request to "/posts/1"
    Then the response status code should be 201