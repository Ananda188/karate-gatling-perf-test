Feature: As a leaving member, I would like to delete my personal details
  Background:
    Given url baseUrl
    And path 'api/users/2'
  Scenario: Successful login
    When method DELETE
    Then status 204
