package com.spartaglobal.moviesapi;


import com.spartaglobal.moviesapi.controller.DataValidation;
import com.spartaglobal.moviesapi.controller.FilmFactory;
import com.spartaglobal.moviesapi.dto.Film;
import com.spartaglobal.moviesapi.filehandling.CsvWriter;
import com.spartaglobal.moviesapi.filehandling.CsvReader;
import com.spartaglobal.moviesapi.repository.FilmRepository;
import java.util.ArrayList;
import java.util.List;

public class FileProcessor {

  FilmRepository filmRepository;

  public void process(String filePath) {
    cleanFile(filePath);
    FilmFactory filmFactory = new FilmFactory();
    List<String[]> filmList = CsvReader.readFileWithoutHeaders("cleanRecords.csv");
    for (String[] filmString : filmList) {
      Film film = filmFactory.createFilm(filmString);
      filmRepository.save(film);
    }
  }

  public void cleanFile(String filePath) {
    List<String[]> rawRecords = CsvReader.readFileWithHeaders(filePath);
    List<String[]> validRecords = new ArrayList<>();
    List<String[]> invalidRecords = new ArrayList<>();

    for (String[] rawRecord : rawRecords) {
      boolean isValid = DataValidation.validateData(rawRecord);

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

