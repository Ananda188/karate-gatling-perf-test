Feature: As a new member, I would like to register
  Background:
    Given url baseUrl
    And path 'api/register'

  Scenario: Successful member registrations
    * def memberDetails =
    """
    {
    "email": "eve.holt@reqres.in",
    "password": "pistol"
}
    """

    And request memberDetails

    When method POST
    Then status 200

