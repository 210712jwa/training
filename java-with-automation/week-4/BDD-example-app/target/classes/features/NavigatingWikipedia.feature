Feature: As a seeker of knowledge I can navigate between different Wiki languages

  Scenario: As a user I can navigate to the English Wiki homepage
    Given I am on the main Wikipedia page
    When  I click on the English Wiki link
    Then  I should be on the English Wiki homepage

  Scenario: As a user I can navigate to the Spanish Wiki homepage
    Given I am on the main Wikipedia page
    When  I click on the Spanish Wiki link
    Then  I should be on the Spanish Wiki homepage

  Scenario: As a user I can navigate to the Italian Wiki homepage
    Given I am on the main Wikipedia page
    When  I click on the Italian Wiki link
    Then  I should be on the Italian Wiki homepage