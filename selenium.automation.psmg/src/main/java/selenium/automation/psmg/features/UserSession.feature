#Feature: User session
#
#  Scenario Outline: Login is possible with valid credentials
#    Given the authentication page is accessed
#    When the user introduces a valid email
#    And a valid pass
#    Then the "<authenticated>" page is displayed
#
#    Examples:
#      |authenticated|
#      |My account   |
#
#
#  Scenario: Logout is possible
#    Given the user is logged in
#    When the user signs out
#    Then the user is logged out