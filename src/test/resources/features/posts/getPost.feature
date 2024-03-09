Feature: GET request on the json-server API

  Scenario: GET a profile from the API
    When I send a GET request to "/posts/1"
    Then the response status code should be 200
      #And the response should include key "id" and value "1"