Feature: As a member, I would like to login successfully
  Background:
    Given url baseUrl
    And path 'api/users'
  Scenario: Successful login
    * def memberDetails =
    """
{
    "name": "morpheus",
    "job": "leader"
}
    """
    And request memberDetails
    When method POST
    Then status 201
