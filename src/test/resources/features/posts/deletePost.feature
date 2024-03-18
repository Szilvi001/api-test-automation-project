Feature: Delete post on the json-server API

  Scenario: DELETE a post from the API
    When I send a DELETE request to "/posts/1"
    Then the response status code should be 200

  Scenario: DELETE a post from the API - non-existent id
    When I send a DELETE request to "/posts/999"
    Then the response status code should be 404

  Scenario: DELETE a post from the API - repeated deletion
    When I send a DELETE request to "/posts/1"
    Then the response status code should be 200
    When I send a DELETE request to "/posts/1"
    Then the response status code should be 404