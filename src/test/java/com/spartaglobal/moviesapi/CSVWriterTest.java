package com.spartaglobal.moviesapi;

import com.spartaglobal.moviesapi.csvwriter.CSVWriter;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class CSVWriterTest {

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

    Boolean writeSuccessful = CSVWriter.writeListOfStringArraysToCSV(films, writeOutFile);

    Assertions.assertTrue(writeSuccessful);
  }

  @Test
  void invalidData() {
    String inValidDataFile = "src/test/resources/TestCSVFiles/InvalidData.csv";

    //Invalid csv line - title ,duration, actor 3 is missing.
    String[] inValidFilm = {"","3.2","2011","","PG-13", "237000000",
        "Action|Adventure|Fantasy|Sci-Fi", "760505847","James Cameron","CCH Pounder",
        "Joel David Moore","","English","USA"};

    List<String[]> films = new ArrayList<>();
    films.add(inValidFilm);

    Boolean writeSuccessful = CSVWriter.writeListOfStringArraysToCSV(films, inValidDataFile);

    Assertions.assertTrue(writeSuccessful);
  }

  @Test
  @Disabled
  //Can't currently throw exception so unable to assert it gets thrown
  void failedToWriteToFileTest() {
//    String writeOutFile = "src/test/resources/TestCSVFiles/TestOutCSVFile.csv";

//    List<String[]> films = new ArrayList<>();

//    //Create mockfilm to try and add
//    String[] spiderMan = {"Spider Man", "4.2", "2012", "110", "PG-13", " 238000000",
//        "Action|Adventure|Sci-Fi", "760505848", "Sam Raimi", "Tom Holland",
//        "Toby Maguire", "Andrew Garfield", "English", "USA"};

//    films.add(spiderMan);

////    Boolean failedToWrite = CSVWriter.writeListOfStringArraysToCSV(films, writeOutFile);

//    assertThatThrownBy(() -> CSVWriter.writeListOfStringArraysToCSV(films, writeOutFile))
//        .isInstanceOf(IOException.class);

//    Assertions.assertThrows(IOException);
//    Assertions.assertFalse(failedToWrite);
  }

}
