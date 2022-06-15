Feature: Film data csv file successfully loaded into database, invalid records written out to error
  file

  Scenario: Full load of file
    Given The full input file
    When We attempt to load the records to the database
    Then There are 5 of records in the database