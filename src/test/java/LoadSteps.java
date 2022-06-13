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
  }

  @When("We attempt to load the records to the database")
  public void weAttemptToLoadTheRecordsToTheDatabase() {
    // TODO Create class which loads database records
    throw new PendingException();
  }

  @Then("{int} invalid records are written out to an error file")
  public void invalidRecordsAreWrittenOutToAnErrorFile(int expectedNumberOfInvalidRecords)
      throws IOException {
    BufferedReader buff = new BufferedReader(new FileReader(""));

    // Doesn't expect headers in error output files
    int actualNumberOfInvalidRecords = 0;
    while ((buff.readLine()) != null) {
      actualNumberOfInvalidRecords++;
    }

    Assertions.assertEquals(expectedNumberOfInvalidRecords, actualNumberOfInvalidRecords);
  }
}
