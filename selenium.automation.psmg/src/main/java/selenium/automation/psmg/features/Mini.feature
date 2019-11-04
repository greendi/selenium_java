Feature: Mini website

  Scenario: Login
    Given the landing page is displayed
    When the user introduces valid credentials
    Then the user should be logged in