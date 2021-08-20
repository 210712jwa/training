Feature: As a scholar I can look up different articles of information
  Scenario Outline:
    Given The user is on the English Wikipedia homepage
    When  The user enters "<input>" into the searchbar
    When  The user clicks the search button
    Then  The user should be sent to a new page with the title "<title>"

    Examples:
      | input | title |
      | java  | Java - Wikipedia |
      | spicy | Pungency - Wikipedia |
      | sports| Sport - Wikipedia    |