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

  public void process(String filePath) {
    cleanFile(filePath);
    loadDb("cleanRecords.csv");
  }

  private void cleanFile(String filePath) {
    List<String[]> rawRecords = CsvReader.readFile(filePath);
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

  private void loadDb(String filePath) {
    FilmFactory filmFactory = new FilmFactory();
    List<String[]> filmList = CsvReader.readFile(filePath);
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
        film.getDirector(), film.getActor1(), film.getActor2(), film.getActor3(), film.getLanguage(),
        film.getCountry());
  }

  private void loader(List<FilmDto> films) {
    PreparedStatement preparedStatement;
    try {
      Connection con = ConnectionFactory.getConnection();
      for (FilmDto filmDto : films) {
        String sqlStatement = """
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
        preparedStatement = con.prepareStatement( sqlStatement );
        for(int i = 1; i <= films.size(); i++) {
          preparedStatement.setString(1, films.get(i - 1).getTitle());
          preparedStatement.setDouble(2, films.get(i - 1).getScore());
          preparedStatement.setInt(3, films.get(i - 1).getYear());
          preparedStatement.setInt(4, films.get(i - 1).getDuration());
          preparedStatement.setString(5, films.get(i - 1).getRating());
          preparedStatement.setLong(6, films.get(i - 1).getBudget());
          preparedStatement.setString(7, films.get(i - 1).getGenre());
          preparedStatement.setLong(8, films.get(i - 1).getGross());
          preparedStatement.setString(9, films.get(i - 1).getDirector());
          preparedStatement.setString(10, films.get(i - 1).getActor1());
          preparedStatement.setString(11, films.get(i - 1).getActor2());
          preparedStatement.setString(12, films.get(i - 1).getActor3());
          preparedStatement.setString(13, films.get(i - 1).getLanguage());
          preparedStatement.setString(14, films.get(i - 1).getCountry());

          preparedStatement.addBatch();
        }

        preparedStatement.executeBatch();
        con.close();
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

}
