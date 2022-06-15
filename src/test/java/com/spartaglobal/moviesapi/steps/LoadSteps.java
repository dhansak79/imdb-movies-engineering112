package com.spartaglobal.moviesapi.steps;

import com.spartaglobal.moviesapi.FileProcessor;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.junit.jupiter.api.Assertions;

public class LoadSteps {

  private String filePath = "";

  @Given("An input file with five valid and five invalid records")
  public void anInputFileWithFiveValidAndFiveInvalidRecords() {
    filePath = "src/test/resources/testdatafiles/5Valid5InvalidRecords.csv";
//    filePath = "src/main/resources/imdb_data.csv";
  }

  @When("We attempt to clean the records")
  public void weAttemptToCleanTheRecords() {
    FileProcessor fileProcessor = new FileProcessor();
    fileProcessor.cleanFile(filePath);
  }

  @When("We attempt to load the records to the database")
  public void weAttemptToLoadTheRecordsToTheDatabase() {
    FileProcessor fileProcessor = new FileProcessor();
    fileProcessor.process(filePath);
  }

  @Then("{int} invalid records are written out to an error file")
  public void invalidRecordsAreWrittenOutToAnErrorFile(int expectedNumberOfInvalidRecords)
      throws IOException {
    int actualNumberOfInvalidRecords = getNumberOfRecordsFromFile("invalidRecords.csv");

    Assertions.assertEquals(expectedNumberOfInvalidRecords, actualNumberOfInvalidRecords);
  }

  @Then("{int} valid records are written out to a clean records file")
  public void validRecordsAreWrittenOutToACleanRecordsFile(int expectedNumberOfValidRecords)
      throws IOException {
    int actualNumberOfValidRecords = getNumberOfRecordsFromFile("cleanRecords.csv");

    Assertions.assertEquals(expectedNumberOfValidRecords, actualNumberOfValidRecords);
  }

  private int getNumberOfRecordsFromFile(String fileName) throws IOException {
    BufferedReader buff = new BufferedReader(new FileReader(fileName));

    // Doesn't expect headers in error output files
    int numberOfRecords = 0;
    while ((buff.readLine()) != null) {
      numberOfRecords++;
    }
    return numberOfRecords;
  }

  @Given("The full input file")
  public void theFullInputFile() {
    filePath = "src/test/resources/com/spartaglobal/moviesapi/imdb_data.csv";

  }

}
