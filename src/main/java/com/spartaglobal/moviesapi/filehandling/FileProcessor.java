package com.spartaglobal.moviesapi.filehandling;


import com.spartaglobal.moviesapi.model.Film;
import com.spartaglobal.moviesapi.model.FilmFactory;
import com.spartaglobal.moviesapi.validation.CsvRowValidator;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class FileProcessor {

  private static final Logger logger = LogManager.getLogger(FileProcessor.class);

  public List<Film> process(String filePath) {
    writeFiles(filePath);
    FilmFactory filmFactory = new FilmFactory();
    List<String[]> filmList = CsvReader.readFileWithoutHeaders("cleanRecords.csv");
    logger.info("Reading records cleanRecords.csv");
    List<Film> films = new ArrayList<>();
    for (String[] filmString : filmList) {
      films.add(filmFactory.createFilm(filmString));
    }
    return films;
  }

  public void writeFiles(String filePath) {
    List<String[]> rawRecords = CsvReader.readFileWithHeaders(filePath);
    List<String[]> validRecords = new ArrayList<>();
    List<String[]> invalidRecords = new ArrayList<>();

    for (String[] rawRecord : rawRecords) {
      boolean isValid = CsvRowValidator.validateData(rawRecord);

      if (isValid) {
        validRecords.add(rawRecord);
      } else {
        invalidRecords.add(rawRecord);
      }
    }

    CsvWriter.writeListOfStringArraysToCSV(validRecords, "cleanRecords.csv");
    CsvWriter.writeListOfStringArraysToCSV(invalidRecords, "invalidRecords.csv");
  }

}

