Feature: Create post on the json-server API

  Scenario: Create a post to the API
    Given the POST request is prepared
    When I send a POST request to "/posts"
    Then the response status code should be 201

  Scenario: Create a post to the API with empty request body
    Given the POST request is prepared with empty request body
    When I send a POST request to "/posts"
    Then the response status code should be 201
