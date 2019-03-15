Feature: Register page

  Scenario Outline: Cannot register with an invalid email
    Given the register page is accessed
    When the user introduces an invalid email "<email>"
    Then the error message "<message>" is displayed

    Examples:
      | email   | message                |
      | 123@123 | Invalid email address. |