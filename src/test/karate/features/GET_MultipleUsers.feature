Feature: I would like to see the details of all members
  Background:
    Given url baseUrl
    And path 'api/users'
  Scenario: Successful login
    * def query =
    """
  {
  "page": "2"
  }
    """

    And params query
    When method GET
    Then status 200
