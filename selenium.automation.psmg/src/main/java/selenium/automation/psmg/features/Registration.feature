#Feature: Registration
#
#  Scenario Outline: Cannot register with an invalid email
#    Given the authentication page is accessed
#    When the user introduces an invalid email "<email>"
#    Then the error message "<message>" is displayed
#
#    Examples:
#      | email   | message                |
#      | 123@123 | Invalid email address. |
#
#  Scenario Outline: Registration is possible with valid input
#    Given the authentication page is accessed
#    And the user introduces a valid unregistered email
#    When the user makes valid inputs for all mandatory fields
#    Then the "<authenticated>" page is displayed
#
#    Examples:
#      |authenticated|
#      |My account   |