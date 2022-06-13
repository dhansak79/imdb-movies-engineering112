package com.spartaglobal.moviesapi;

import com.spartaglobal.moviesapi.writecsvfile.WriteOutCSVFile;
import io.cucumber.java.bs.A;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WriteOutCSVFileTest {

  @Test
  public void writeCSVData() {
    String writeOutFile = "src/test/resources/TestCSV/TestOutCSVFile.csv";
    List<String[]> films = new ArrayList<>();

    String [] filmSpiderMan =  {"Spider Man", "4.2", "2012", "110", "PG-13", " 238000000",
        "Action|Adventure|Sci-Fi", "760505848", "Sam Raimi", "Tom Holland",
        "Toby Maguire", "Andrew Garfield", "English", "USA"};

    String [] filmTitanic = {"Titanic", "7.7", "1997", "194", "PG-13", " 200000000",
        "Drama/Adventure", "658672302", "James Cameron", "Leonardo diCaprio",
        "Kate Winslet", "Gloria Staurt", "English", "USA"};

    String [] filmMarvel=  {"Marvel", "3.2", "2011", "122", "PG-13", " 237000000",
        "Action|Adventure|Fantasy|Sci-Fi", "760505847", "James Cameron", "CCH Pounder",
        "Joel David Moore", "Wes Studi", "English", "USA"};


    films.add(filmMarvel);
    films.add(filmTitanic);
    films.add(filmSpiderMan);

    Boolean success = WriteOutCSVFile.writeOutCSVFile(films, writeOutFile);

    Assertions.assertTrue(success);
  }

  @Test
  public void inValidData(){
    String writeInValidData ="src/test/resources/TestCSV/InValidData.csv";
    //title ,duration, actor 3 is missing.
    String  inValidFilm = (",3.2,2011,,PG-13, "
        + "237000000,Action|Adventure|Fantasy|Sci-Fi,760505847,James Cameron,"
        + "CCH Pounder,Joel David Moore,,English,USA");
    Boolean successful= WriteOutCSVFile.corruptData(inValidFilm,writeInValidData);


    Assertions.assertTrue(successful);



  }
}
