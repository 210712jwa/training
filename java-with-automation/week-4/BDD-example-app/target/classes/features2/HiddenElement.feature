Feature: As a user I want to click a hidden button
  Scenario: As a user I click a hidden button
    Given The user is on the webpage that has a hidden button
    When  The user clicks the hidden button
    Then  The user should be on the second page