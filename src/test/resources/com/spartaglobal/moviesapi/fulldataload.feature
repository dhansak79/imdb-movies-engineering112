Feature: Film data csv file successfully loaded into database, invalid records written out to error
  file

  Scenario: Full load of file
    Given The full input file
    When We attempt to load the records to the database
    Then 3547 valid records are written out to a clean records file
    And 1496 invalid records are written out to an error file