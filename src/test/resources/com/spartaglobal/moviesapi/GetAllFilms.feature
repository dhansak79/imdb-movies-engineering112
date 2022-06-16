Feature: User is able to retrieve a list of all films

  Scenario: Retrieve all films
    Given there are 5 films
    When I get all films
    Then all 5 films are returned

  Scenario: Retrieve all films (when there are none)
    Given there are 0 films
    When I get all films
    Then I get no films