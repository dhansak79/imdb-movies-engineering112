Feature: Utilise the API to get all movies from the database

  Scenario: Retrieve all films from the database
    Given the API has a get all movies endpoint
    When we make the call to get all movies
    Then we receive a JSON response body with all the movies