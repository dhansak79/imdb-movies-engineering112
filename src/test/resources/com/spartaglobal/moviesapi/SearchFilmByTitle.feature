Feature: User is able to search for a film using the title

  Background:
    Given The full input file
    And We attempt to load the records to the database

  Scenario: Retrieve all films that start with a given character

    When We search for "A"
    Then films starting with "A" are returned

  Scenario Outline: Retrieve all films that contain a string

    When We search for <Search>
    Then films containing <Response> are returned
    Examples:
      | Search  | Response |
      | "Bat"   | "bat"    |
      | "bat"   | "bat"    |
      | "BAT"   | "bat"    |
      | "bAT"   | "bat"    |
      | "Super" | "super"  |
      | "bro"   | "bro"    |



