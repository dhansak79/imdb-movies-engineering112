package com.spartaglobal.moviesapi;

import com.spartaglobal.moviesapi.csvwriter.CSVWriter;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class CSVWriterTest {

  @Test
  public void writeCSVData() {
    String writeOutFile = "src/test/resources/TestCSV/TestOutCSVFile.csv";

    List<String[]> films = new ArrayList<>();

    //Create fake clean films to add to new csv
    String[] SpiderMan = {"Spider Man", "4.2", "2012", "110", "PG-13", " 238000000",
        "Action|Adventure|Sci-Fi", "760505848", "Sam Raimi", "Tom Holland",
        "Toby Maguire", "Andrew Garfield", "English", "USA"};

    String[] Titanic = {"Titanic", "7.7", "1997", "194", "PG-13", " 200000000",
        "Drama/Adventure", "658672302", "James Cameron", "Leonardo diCaprio",
        "Kate Winslet", "Gloria Staurt", "English", "USA"};

    String[] Avatar = {"Avatar", "3.2", "2011", "122", "PG-13", " 237000000",
        "Action|Adventure|Fantasy|Sci-Fi", "760505847", "James Cameron", "CCH Pounder",
        "Joel David Moore", "Wes Studi", "English", "USA"};

    films.add(Avatar);
    films.add(Titanic);
    films.add(SpiderMan);

    Boolean writeSuccessful = CSVWriter.writeListOfStringsToCSV(films, writeOutFile);

    Assertions.assertTrue(writeSuccessful);
  }

  @Test
  public void invalidData() {
    String invalidDataFile = "src/test/resources/TestCSV/invalidData.csv";

    //Invalid csv line - title ,duration, actor 3 is missing.
    String invalidFilmLine = (",3.2,2011,,PG-13, 237000000,Action|Adventure|Fantasy|Sci-Fi,"
        + "760505847,James Cameron,CCH Pounder,Joel David Moore,,English,USA");

    Boolean writeSuccessful = CSVWriter.writeIncorruptLinesToCSV(invalidFilmLine, invalidDataFile);

    Assertions.assertTrue(writeSuccessful);
  }

  @Test
  @Disabled
  public void failedToWriteToFileTest() {
    String writeOutFile = "src/test/resources/TestCSV/TestOutCSVFile.csv";

    List<String[]> films = new ArrayList<>();

    //Create mockfilm to try and add
    String[] SpiderMan = {"Spider Man", "4.2", "2012", "110", "PG-13", " 238000000",
        "Action|Adventure|Sci-Fi", "760505848", "Sam Raimi", "Tom Holland",
        "Toby Maguire", "Andrew Garfield", "English", "USA"};

    Boolean failedToWrite = CSVWriter.writeListOfStringsToCSV(films, writeOutFile);

    //Assertions.assertThrows(IOException);
    Assertions.assertFalse(failedToWrite);
  }

}
