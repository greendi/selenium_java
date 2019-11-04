Feature: Google search

  Scenario Outline: Simple Google search
    Given a web browser is on the Google page
    When the search phrase "<phrase>" is entered
    Then results for "<phrase>" are shown
    And the related results include "<related>"

    Examples: Animals
      |phrase   |related       |
      |panda    |Panda Express |
      |elephant |Elephant man  |