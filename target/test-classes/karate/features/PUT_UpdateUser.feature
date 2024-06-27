Feature: As a member, I would like to update my personal details
  Background:
    Given url baseUrl
    And path 'api/users/2'
  Scenario: Successful login
    * def memberDetails =
    """
{
    "name": "morpheus",
    "job": "zion resident"
}
    """
    And request memberDetails
    When method PUT
    Then status 200
