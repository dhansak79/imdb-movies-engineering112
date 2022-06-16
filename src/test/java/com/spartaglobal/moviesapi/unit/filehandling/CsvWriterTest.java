package com.spartaglobal.moviesapi.unit.filehandling;

import static org.assertj.core.api.Assertions.assertThat;

import com.spartaglobal.moviesapi.filehandling.CsvWriter;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class CsvWriterTest {

  @Test
  void writeCSVData() {
    String writeOutFile = "src/test/resources/TestCSVFiles/TestOutCSVFile.csv";

    List<String[]> films = new ArrayList<>();

    //Create fake clean films to add to new csv
    String[] spiderMan = {"Spider Man", "4.2", "2012", "110", "PG-13", " 238000000",
        "Action|Adventure|Sci-Fi", "760505848", "Sam Raimi", "Tom Holland",
        "Toby Maguire", "Andrew Garfield", "English", "USA"};

    String[] titanic = {"Titanic", "7.7", "1997", "194", "PG-13", " 200000000",
        "Drama/Adventure", "658672302", "James Cameron", "Leonardo diCaprio",
        "Kate Winslet", "Gloria Staurt", "English", "USA"};

    String[] avatar = {"Avatar", "3.2", "2011", "122", "PG-13", " 237000000",
        "Action|Adventure|Fantasy|Sci-Fi", "760505847", "James Cameron", "CCH Pounder",
        "Joel David Moore", "Wes Studi", "English", "USA"};

    films.add(avatar);
    films.add(titanic);
    films.add(spiderMan);

    Boolean writeSuccessful = CsvWriter.writeListOfStringArraysToCSV(films, writeOutFile);

    Assertions.assertTrue(writeSuccessful);
  }

  @Test
  void invalidData() {
    String inValidDataFile = "src/test/resources/TestCSVFiles/InvalidData.csv";

    //Invalid csv line - title ,duration, actor 3 is missing.
    String[] inValidFilm = {"", "3.2", "2011", "", "PG-13", "237000000",
        "Action|Adventure|Fantasy|Sci-Fi", "760505847", "James Cameron", "CCH Pounder",
        "Joel David Moore", "", "English", "USA"};

    List<String[]> films = new ArrayList<>();
    films.add(inValidFilm);

    Boolean writeSuccessful = CsvWriter.writeListOfStringArraysToCSV(films, inValidDataFile);

    Assertions.assertTrue(writeSuccessful);
  }

  @Test
  void failedToWriteToFileTest() {
    String writeOutFile = "src/test/resources/TestCSVFiles";

    List<String[]> films = new ArrayList<>();

    //Create mockfilm to try and add
    String[] spiderMan = {"Spider Man", "4.2", "2012", "110", "PG-13", " 238000000",
        "Action|Adventure|Sci-Fi", "760505848", "Sam Raimi", "Tom Holland",
        "Toby Maguire", "Andrew Garfield", "English", "USA"};

    films.add(spiderMan);

    Boolean failedToWrite = CsvWriter.writeListOfStringArraysToCSV(films, writeOutFile);

    assertThat(failedToWrite).isFalse();
  }

}
