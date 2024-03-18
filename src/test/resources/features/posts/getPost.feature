Feature: GET request on the json-server API

  Scenario: GET a post from the API
    When I send a GET request to "/posts/1"
    Then the response status code should be 200
    And the response payload should be correct

  Scenario: GET a post from the API - non-existent id
    When I send a GET request to "/posts/999"
    Then the response status code should be 404

  Scenario: GET a post from the API - null id
    When I send a GET request to "/posts/null"
    Then the response status code should be 404