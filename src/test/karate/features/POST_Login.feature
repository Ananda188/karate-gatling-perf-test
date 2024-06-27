Feature: I want to create a new user
  Background:
    Given url baseUrl
    And path 'api/login'
  Scenario: Create new user successfully
    * def memberDetails =
    """
      {
    "email": "eve.holt@reqres.in",
    "password": "cityslicka"
}
    """
    And request memberDetails
    When method POST
    Then status 200
