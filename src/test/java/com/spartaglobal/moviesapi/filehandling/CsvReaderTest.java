package com.spartaglobal.moviesapi.filehandling;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class CsvReaderTest {

  @Test
  void readFileTest() {
    String testData1 = "src/test/resources/com/spartaglobal/moviesapi/test_csv_files/test_data1.csv";
    List<String[]> actualResult = CsvReader.readCSVFile(testData1, true);
    String[] expectedResult = new String[]{"Avatar", "7.9", "2009", "178", "PG-13", "237000000",
        "Action|Adventure|Fantasy|Sci-Fi", "760505847", "James Cameron", "CCH Pounder",
        "Joel David Moore", "Wes Studi", "English", "USA"};
    assertThat(expectedResult).isEqualTo(actualResult.get(0));
  }

  @Test
  void checkSize() {
    String testData6 = "src/test/resources/com/spartaglobal/moviesapi/test_csv_files/test_data6.csv";
    List<String[]> actualResult = CsvReader.readCSVFile(testData6, true);
    assertEquals(6, actualResult.size());
  }

  @Test
  void fileDoesNotExist() {
    //check returned list is empty and that we get our log msg
    List<String[]> emptyList = CsvReader.readCSVFile("random.csv", true);
    assertThat(emptyList.size()).isZero();
  }

  @Test
  void readMultipleFilms() {
    String testData6 =  "src/test/resources/com/spartaglobal/moviesapi/test_csv_files/test_data6.csv";
    List<String[]> actualResult = CsvReader.readCSVFile(testData6, true);
    String[] avatar = {"Avatar", "7.9", "2009", "178", "PG-13", "237000000",
        "Action|Adventure|Fantasy|Sci-Fi", "760505847", "James Cameron", "CCH Pounder",
        "Joel David Moore", "Wes Studi", "English", "USA"};
    String[] pirateOfTheCaribbean = {"Pirates of the Caribbean: At World's End", "7.1", "2007",
        "169", "PG-13", "300000000", "Action|Adventure|Fantasy", "309404152", "Gore Verbinski",
        "Johnny Depp", "Orlando Bloom", "Jack Davenport", "English", "USA"};
    String[] spectre = {"Spectre", "6.8", "2015", "148", "PG-13", "245000000",
        "Action|Adventure|Thriller", "200074175", "Sam Mendes", "Christoph Waltz", "Rory Kinnear",
        "Stephanie Sigman", "English", "UK"};
    String[] theDarkKnightRises = {"The Dark Knight Rises", "8.5", "2012", "164", "PG-13",
        "250000000", "Action|Thriller", "448130642", "Christopher Nolan", "Tom Hardy",
        "Christian Bale", "Joseph Gordon-Levitt", "English", "USA"};
    String[] johnCarter = {"John Carter", "6.6", "2012", "132", "PG-13", "263700000",
        "Action|Adventure|Sci-Fi", "73058679", "Andrew Stanton", "Daryl Sabara", "Samantha Morton",
        "Polly Walker", "English", "USA"};
    String[] batman = {"Batman v Superman: Dawn of Justice", "6.9", "2016", "183", "PG-13",
        "250000000", "Action|Adventure|Sci-Fi", "330249062", "Zack Snyder", "Henry Cavill",
        "Lauren Cohan", "Alan D. Purwin", "English", "USA"};

    List<String[]> expectedResult = new ArrayList<>();
    expectedResult.add(avatar);
    expectedResult.add(pirateOfTheCaribbean);
    expectedResult.add(spectre);
    expectedResult.add(theDarkKnightRises);
    expectedResult.add(johnCarter);
    expectedResult.add(batman);

    assertThat(Arrays.deepToString(expectedResult.toArray())).isEqualTo(
        Arrays.deepToString(actualResult.toArray()));
  }
}
