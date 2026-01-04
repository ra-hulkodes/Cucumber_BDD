@API
Feature: Get User API headers

  Scenario: Get response headers
    Given the base URI is "https://httpbin.org"
    When I send a GET request to "/json"
    Then the response status code should be 200