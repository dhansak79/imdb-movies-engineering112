Feature: Film data csv file successfully loaded into database, invalid records written out to error
  file

  Scenario: Invalid records written out to error file
    Given An input file with five valid and five invalid records
    When We attempt to load the records to the database
    Then 5 invalid records are written out to an error file