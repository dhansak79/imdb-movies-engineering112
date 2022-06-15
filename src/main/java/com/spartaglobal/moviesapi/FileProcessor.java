package com.spartaglobal.moviesapi;

import com.spartaglobal.moviesapi.controller.ConnectionFactory;
import com.spartaglobal.moviesapi.controller.DataValidation;
import com.spartaglobal.moviesapi.controller.FilmFactory;
import com.spartaglobal.moviesapi.dto.FilmDto;
import com.spartaglobal.moviesapi.filehandling.CsvWriter;
import com.spartaglobal.moviesapi.filehandling.CsvReader;
import com.spartaglobal.moviesapi.model.Film;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FileProcessor {

  private static final String SQL_STATEMENT = """
      INSERT INTO films (
      title,
      score,
      release_year,
      duration,
      rating,
      budget,
      genres,
      gross,
      director,
      actor1,
      actor2,
      actor3,
      film_language,
      country)
      VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
      """;

  public void process(String filePath) {
    cleanFile(filePath);
    loadDb("cleanRecords.csv");
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

  public void loadDb(String filePath) {
    FilmFactory filmFactory = new FilmFactory();
    List<String[]> filmList = CsvReader.readFileWithoutHeaders(filePath);
    List<FilmDto> films = new ArrayList();
    for (String[] filmString : filmList) {
      Film film = filmFactory.createFilm(filmString);
      films.add(convertModel(film));
    }

    loader(films);
  }

  private FilmDto convertModel(Film film) {
    return new FilmDto(film.getTitle(), film.getScore(), film.getYear(),
        film.getDuration(), film.getRating(), film.getBudget(), film.getGenre(), film.getGross(),
        film.getDirector(), film.getActor1(), film.getActor2(), film.getActor3(),
        film.getLanguage(),
        film.getCountry());
  }

  private void loader(List<FilmDto> films) {
    PreparedStatement preparedStatement;
    Connection con;
      con = ConnectionFactory.getConnection();

    try {
      preparedStatement = con.prepareStatement(SQL_STATEMENT);
      for (FilmDto film : films) {
        preparedStatement.setString(1, film.getTitle());
        preparedStatement.setDouble(2, film.getScore());
        preparedStatement.setInt(3, film.getYear());
        preparedStatement.setInt(4, film.getDuration());
        preparedStatement.setString(5, film.getRating());
        preparedStatement.setLong(6, film.getBudget());
        preparedStatement.setString(7, film.getGenre());
        preparedStatement.setLong(8, film.getGross());
        preparedStatement.setString(9, film.getDirector());
        preparedStatement.setString(10, film.getActor1());
        preparedStatement.setString(11, film.getActor2());
        preparedStatement.setString(12, film.getActor3());
        preparedStatement.setString(13, film.getLanguage());
        preparedStatement.setString(14, film.getCountry());

        preparedStatement.addBatch();
      }
      preparedStatement.executeBatch();
      con.close();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}

