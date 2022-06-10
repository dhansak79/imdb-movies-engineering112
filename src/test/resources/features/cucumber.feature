Feature: login page
  allows users to log in using their details
  Scenario: a valid login page
    Given all details are correct
    When the user presses the login button
    Then their details are accepted and log in