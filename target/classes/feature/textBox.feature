Feature: TextBox option tests
  @hello
  Scenario Outline: Testing textbox elemenrs
    Given I am navigating to the <URI>
    When I click on textbox option
    And I enter all the textbox enterDetails
    Then I quit the application

    Examples:
      | URI                         |
      | https://demoqa.com/elements |