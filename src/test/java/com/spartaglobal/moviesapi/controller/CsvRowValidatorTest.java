package com.spartaglobal.moviesapi.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.spartaglobal.moviesapi.filehandling.validation.exceptions.ValidateMoviesException.InvalidBudgetException;
import com.spartaglobal.moviesapi.filehandling.validation.exceptions.ValidateMoviesException.InvalidCountryException;
import com.spartaglobal.moviesapi.filehandling.validation.exceptions.ValidateMoviesException.InvalidDurationException;
import com.spartaglobal.moviesapi.filehandling.validation.exceptions.ValidateMoviesException.InvalidGenreException;
import com.spartaglobal.moviesapi.filehandling.validation.exceptions.ValidateMoviesException.InvalidGross;
import com.spartaglobal.moviesapi.filehandling.validation.exceptions.ValidateMoviesException.InvalidLanguageException;
import com.spartaglobal.moviesapi.filehandling.validation.exceptions.ValidateMoviesException.InvalidNameException;
import com.spartaglobal.moviesapi.filehandling.validation.exceptions.ValidateMoviesException.InvalidRatingException;
import com.spartaglobal.moviesapi.filehandling.validation.exceptions.ValidateMoviesException.InvalidScoreException;
import com.spartaglobal.moviesapi.filehandling.validation.exceptions.ValidateMoviesException.InvalidTitleException;
import com.spartaglobal.moviesapi.filehandling.validation.exceptions.ValidateMoviesException.InvalidYearException;
import com.spartaglobal.moviesapi.filehandling.validation.ActorsNamesValidationRule;
import com.spartaglobal.moviesapi.filehandling.validation.BudgetValidationRule;
import com.spartaglobal.moviesapi.filehandling.validation.CountryValidationRule;
import com.spartaglobal.moviesapi.filehandling.validation.CsvRowValidator;
import com.spartaglobal.moviesapi.filehandling.validation.DurationValidationRule;
import com.spartaglobal.moviesapi.filehandling.validation.FilmCsvRow;
import com.spartaglobal.moviesapi.filehandling.validation.GenreValidationRule;
import com.spartaglobal.moviesapi.filehandling.validation.GrossValidationRule;
import com.spartaglobal.moviesapi.filehandling.validation.LanguageValidationRule;
import com.spartaglobal.moviesapi.filehandling.validation.RatingValidationRule;
import com.spartaglobal.moviesapi.filehandling.validation.ScoreValidationRule;
import com.spartaglobal.moviesapi.filehandling.validation.TitleValidationRule;
import com.spartaglobal.moviesapi.filehandling.validation.YearValidationRule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CsvRowValidatorTest {

  private static final String[] VALID_DATA_SAMPLE = {"Avatar", "7.9", "2009", "178", "PG-13",
      "237000000", "Action|Adventure|Fantasy|Sci-Fi", "760505847", "James Cameron", "CCH Pounder",
      "Joel David Moore", "Wes Studi", "English", "USA"};

  private static final FilmCsvRow FILM = new FilmCsvRow("Avatar", "7.9", "2009", "178",
      "PG-13",
      "237000000", "Action|Adventure|Fantasy|Sci-Fi", "760505847", "James Cameron", "CCH Pounder",
      "Joel David Moore", "Wes Studi", "English", "USA");

  // Intentionally removed Movie Title to create invalid data length
  private static final String[] INVALID_DATA_LENGTH_SAMPLE = {"7.9", "2009", "178", "PG-13",
      "237000000", "Action|Adventure|Fantasy|Sci-Fi", "760505847", "James Cameron", "CCH Pounder",
      "Joel David Moore", "Wes Studi", "English", "USA"};

  @Test
  void validDataTest() {
    Assertions.assertTrue(CsvRowValidator.validateData(VALID_DATA_SAMPLE));
  }

  @Test
  void invalidTitleTest() {
    FilmCsvRow film = new FilmCsvRow("", "7.9", "2009", "178",
        "PG-13",
        "237000000", "Action|Adventure|Fantasy|Sci-Fi", "760505847", "James Cameron", "CCH Pounder",
        "Joel David Moore", "Wes Studi", "English", "USA");
    Throwable throwable = assertThrows(InvalidTitleException.class, () ->
        new TitleValidationRule().validate(film));

    assertEquals("Invalid movie title", throwable.getMessage());
  }

  @Test
  void invalidScoreTest() {
    FilmCsvRow film = new FilmCsvRow("Avatar", "seven", "2009", "178",
        "PG-13",
        "237000000", "Action|Adventure|Fantasy|Sci-Fi", "760505847", "James Cameron", "CCH Pounder",
        "Joel David Moore", "Wes Studi", "English", "USA");
    Throwable throwable = assertThrows(InvalidScoreException.class, () ->
        new ScoreValidationRule().validate(film));

    assertEquals("Invalid score", throwable.getMessage());
  }

  @Test
  void invalidYearTest() {
    FilmCsvRow film = new FilmCsvRow("Avatar", "7.9", "202", "178", "PG-13",
        "237000000", "Action|Adventure|Fantasy|Sci-Fi", "760505847", "James Cameron", "CCH Pounder",
        "Joel David Moore", "Wes Studi", "English", "USA");

    Throwable throwable = assertThrows(InvalidYearException.class, () ->
        new YearValidationRule().validate(film));

    assertEquals("Film year is invalid", throwable.getMessage());
  }

  @Test
  void invalidYearNotANumberTest() {
    FilmCsvRow film = new FilmCsvRow("Avatar", "7.9", "fdsf", "178", "PG-13",
        "237000000", "Action|Adventure|Fantasy|Sci-Fi", "760505847", "James Cameron", "CCH Pounder",
        "Joel David Moore", "Wes Studi", "English", "USA");

    Throwable throwable = assertThrows(InvalidYearException.class, () ->
        new YearValidationRule().validate(film));

    assertEquals("Film year is invalid", throwable.getMessage());
  }

  @Test
  void invalidDurationTest() {
    FilmCsvRow film = new FilmCsvRow("Avatar", "7.9", "2009", "199.1452",
        "PG-13",
        "237000000", "Action|Adventure|Fantasy|Sci-Fi", "760505847", "James Cameron", "CCH Pounder",
        "Joel David Moore", "Wes Studi", "English", "USA");

    Throwable throwable = assertThrows(InvalidDurationException.class, () ->
        new DurationValidationRule().validate(film));

    assertEquals("Invalid duration. Duration must be a whole number.", throwable.getMessage());
  }

  @Test
  void invalidBudgetAsTextTest() {
    FilmCsvRow film = new FilmCsvRow("The Godfather", "7.9", "2009", "178",
        "PG-13", "budget", "Action|Adventure|Fantasy|Sci-Fi",
        "760505847", "James Cameron", "CCH Pounder", "Joel David Moore",
        "Wes Studi", "English", "USA");
    Throwable throwable = assertThrows(InvalidBudgetException.class, () ->
        new BudgetValidationRule().validate(film));

    assertEquals("Budget must be a whole number", throwable.getMessage());
  }

  @Test
  void invalidBudgetAsNotWholeNumberTest() {
    FilmCsvRow film = new FilmCsvRow("The Godfather", "7.9", "2009", "178",
        "PG-13", "1.4343", "Action|Adventure|Fantasy|Sci-Fi",
        "760505847", "James Cameron", "CCH Pounder", "Joel David Moore",
        "Wes Studi", "English", "USA");
    Throwable throwable = assertThrows(InvalidBudgetException.class, () ->
        new BudgetValidationRule().validate(film));
    assertEquals("Budget must be a whole number", throwable.getMessage());
  }

  @Test
  void invalidRatingTest() {
    FilmCsvRow film = new FilmCsvRow("Avatar", "7.9", "2009", "178",
        "6713",
        "237000000", "Action|Adventure|Fantasy|Sci-Fi", "760505847", "James Cameron", "CCH Pounder",
        "Joel David Moore", "Wes Studi", "English", "USA");
    Throwable throwable = assertThrows(InvalidRatingException.class, () ->
        new RatingValidationRule().validate(film));

    assertEquals("Film rating is invalid", throwable.getMessage());
  }

  @Test
  void invalidGrossTest() {
    FilmCsvRow film = new FilmCsvRow("Avatar", "7.9", "2009", "178",
        "PG-13",
        "237000000", "Action|Adventure|Fantasy|Sci-Fi", "19515.151", "James Cameron", "CCH Pounder",
        "Joel David Moore", "Wes Studi", "English", "USA");
    Throwable throwable = assertThrows(InvalidGross.class, () ->
        new GrossValidationRule().validate(film));

    assertEquals("Gross is invalid. Gross must be a whole number.", throwable.getMessage());
  }

  @Test
  void invalidActor1NameTest() {
    FilmCsvRow film = new FilmCsvRow("Avatar", "7.9", "2009", "178",
        "PG-13",
        "237000000", "Action|Adventure|Fantasy|Sci-Fi", "760505847", "James Cameron", "",
        "Joel David Moore", "Wes Studi", "English", "USA");
    Throwable throwable = assertThrows(InvalidNameException.class, () ->
        new ActorsNamesValidationRule().validate(film));

    assertEquals("Name is invalid.", throwable.getMessage());
  }

  @Test
  void invalidActor2NameTest() {
    FilmCsvRow film = new FilmCsvRow("Avatar", "7.9", "2009", "178",
        "PG-13",
        "237000000", "Action|Adventure|Fantasy|Sci-Fi", "760505847", "James Cameron", "Joel David Moore",
        "", "Wes Studi", "English", "USA");
    Throwable throwable = assertThrows(InvalidNameException.class, () ->
        new ActorsNamesValidationRule().validate(film));

    assertEquals("Name is invalid.", throwable.getMessage());
  }

  @Test
  void invalidActor3NameTest() {
    FilmCsvRow film = new FilmCsvRow("Avatar", "7.9", "2009", "178",
        "PG-13",
        "237000000", "Action|Adventure|Fantasy|Sci-Fi", "760505847", "James Cameron", "Joel David Moore",
        "Wes Studi", "", "English", "USA");
    Throwable throwable = assertThrows(InvalidNameException.class, () ->
        new ActorsNamesValidationRule().validate(film));

    assertEquals("Name is invalid.", throwable.getMessage());
  }

  @Test
  void invalidGenreTest() {
    FilmCsvRow film = new FilmCsvRow("Avatar", "7.9", "2009", "178",
        "PG-13",
        "237000000", "Invalid movies genre", "760505847", "James Cameron", "CCH Pounder",
        "Joel David Moore", "Wes Studi", "English", "USA");

    Throwable throwable = assertThrows(InvalidGenreException.class,
        () -> new GenreValidationRule().validate(film));

    assertEquals("Invalid movies genre", throwable.getMessage());
  }

  @Test
  void invalidLanguageTest() {
    FilmCsvRow film = new FilmCsvRow("Avatar", "7.9", "2009", "178",
        "PG-13",
        "237000000", "Action|Adventure|Fantasy|Sci-Fi", "760505847", "James Cameron", "CCH Pounder",
        "Joel David Moore", "Wes Studi", "", "USA");
    Throwable throwable = assertThrows(InvalidLanguageException.class, () ->
        new LanguageValidationRule().validate(film));

    assertEquals("Invalid Language Detected", throwable.getMessage());
  }

  @Test
  void invalidCountryTest() {
    FilmCsvRow film = new FilmCsvRow("Avatar", "7.9", "2009", "178",
        "PG-13",
        "237000000", "Action|Adventure|Fantasy|Sci-Fi", "760505847", "James Cameron", "CCH Pounder",
        "Joel David Moore", "Wes Studi", "English", "U");
    Throwable throwable = assertThrows(InvalidCountryException.class,
        () -> new CountryValidationRule().validate(film));

    assertEquals("Invalid Country detected", throwable.getMessage());
  }

}