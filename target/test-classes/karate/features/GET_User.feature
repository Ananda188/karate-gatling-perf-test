Feature: I would like to see the details of a single user
  Background:
    Given url baseUrl
    And path 'api/users/2'
  Scenario: Successful login

    When method GET
    Then status 200
