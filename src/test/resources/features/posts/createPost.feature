Feature: POST request on the json-server API

  Scenario: Create a post to the API
    Given the request is prepared
    When I send a POST request to "/posts"
    Then the response status code should be 201

  Scenario: Create a post to the API with empty request body
    Given the request is prepared
    When I send a POST request to "/posts"
    Then the response status code should be 404

  Scenario: Create a post to the API with invalid JSON schema
    Given the request is prepared
    When I send a POST request to "/posts"
    Then the response status code should be 404