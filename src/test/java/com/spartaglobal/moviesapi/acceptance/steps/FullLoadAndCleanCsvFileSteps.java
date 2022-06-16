package com.spartaglobal.moviesapi.acceptance.steps;

import com.spartaglobal.moviesapi.data.DataLoader;
import com.spartaglobal.moviesapi.data.FilmRepository;
import com.spartaglobal.moviesapi.filehandling.FileProcessor;
import com.spartaglobal.moviesapi.model.Film;
import com.spartaglobal.moviesapi.service.FilmService;
import com.spartaglobal.moviesapi.service.exceptions.NoFilmsInDatabaseException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

public final class FullLoadAndCleanCsvFileSteps {

  @Autowired
  private FilmService service;

  @Autowired
  private FilmRepository filmRepository;

  @Autowired
  private DataLoader dataLoader;

  private String filePath = "";

  @Given("An input file with five valid and five invalid records")
  public void anInputFileWithFiveValidAndFiveInvalidRecords() {
    filePath = "src/test/resources/testdatafiles/5Valid5InvalidRecords.csv";
//    filePath = "src/main/resources/imdb_data.csv";
  }

  @When("We attempt to clean the records")
  public void weAttemptToCleanTheRecords() {
    FileProcessor fileProcessor = new FileProcessor();
    fileProcessor.writeFiles(filePath);
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

  @Given("The full input file")
  public void theFullInputFile() {
    filePath = "src/test/resources/com/spartaglobal/moviesapi/imdb_data.csv";
  }

  @When("We attempt to load the records to the database")
  public void weAttemptToLoadTheRecordsToTheDatabase() {
    dataLoader.loadFileToDatabase(filePath);
  }

  @Then("There are {int} of records in the database")
  public void thereAreOfRecordsInTheDatabase(int expectedNumberOfRecords)
      throws NoFilmsInDatabaseException {
    List<Film> films = service.getAllFilms();
    Assertions.assertEquals(expectedNumberOfRecords, films.size());
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
}
