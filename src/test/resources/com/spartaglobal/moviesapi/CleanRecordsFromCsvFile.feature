Feature: Film data csv file successfully writes out valid records and invalid records to
  respective csv files.
  
  Scenario: Invalid records written out to error file
    Given An input file with five valid and five invalid records
    When We attempt to clean the records
    Then 5 invalid records are written out to an error file

  Scenario: Valid records written out to a clean records file
    Given An input file with five valid and five invalid records
    When We attempt to clean the records
    Then 5 valid records are written out to a clean records file
