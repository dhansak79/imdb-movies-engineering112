package com.spartaglobal.moviesapi.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.spartaglobal.moviesapi.exceptions.ValidateMoviesException.InvalidBudgetException;
import com.spartaglobal.moviesapi.exceptions.ValidateMoviesException.InvalidCountryException;
import com.spartaglobal.moviesapi.exceptions.ValidateMoviesException.InvalidDurationException;
import com.spartaglobal.moviesapi.exceptions.ValidateMoviesException.InvalidGenreException;
import com.spartaglobal.moviesapi.exceptions.ValidateMoviesException.InvalidGross;
import com.spartaglobal.moviesapi.exceptions.ValidateMoviesException.InvalidLanguageException;
import com.spartaglobal.moviesapi.exceptions.ValidateMoviesException.InvalidLengthException;
import com.spartaglobal.moviesapi.exceptions.ValidateMoviesException.InvalidNameException;
import com.spartaglobal.moviesapi.exceptions.ValidateMoviesException.InvalidRatingException;
import com.spartaglobal.moviesapi.exceptions.ValidateMoviesException.InvalidScoreException;
import com.spartaglobal.moviesapi.exceptions.ValidateMoviesException.InvalidTitleException;
import com.spartaglobal.moviesapi.exceptions.ValidateMoviesException.InvalidYearException;
import com.spartaglobal.moviesapi.validation.BudgetValidationRule;
import com.spartaglobal.moviesapi.validation.CountryValidationRule;
import com.spartaglobal.moviesapi.validation.DurationValidationRule;
import com.spartaglobal.moviesapi.validation.FilmCsvRow;
import com.spartaglobal.moviesapi.validation.GenreValidationRule;
import com.spartaglobal.moviesapi.validation.GrossValidationRule;
import com.spartaglobal.moviesapi.validation.LanguageValidationRule;
import com.spartaglobal.moviesapi.validation.LengthValidationRule;
import com.spartaglobal.moviesapi.validation.NameValidationRule;
import com.spartaglobal.moviesapi.validation.RatingValidationRule;
import com.spartaglobal.moviesapi.validation.ScoreValidationRule;
import com.spartaglobal.moviesapi.validation.TitleValidationRule;
import com.spartaglobal.moviesapi.validation.YearValidationRule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DataValidatorTest {

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
    Assertions.assertTrue(DataValidator.validateData(VALID_DATA_SAMPLE));
  }

  @Test
  void invalidDataLengthTest() {
    Throwable throwable = assertThrows(InvalidLengthException.class, () ->
        LengthValidationRule.validate(INVALID_DATA_LENGTH_SAMPLE));

    assertEquals("Incomplete length of data", throwable.getMessage());
  }

  @Test
  void invalidTitleTest() {
    Throwable throwable = assertThrows(InvalidTitleException.class, () ->
        TitleValidationRule.validate(""));

    assertEquals("Invalid movie title", throwable.getMessage());
  }

  @Test
  void invalidScoreTest() {
    Throwable throwable = assertThrows(InvalidScoreException.class, () ->
        ScoreValidationRule.validate("seven"));

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
    Throwable throwable = assertThrows(InvalidDurationException.class, () ->
        DurationValidationRule.validate("199.1452"));

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
    Throwable throwable = assertThrows(InvalidRatingException.class,
        () -> RatingValidationRule.validate("6713"));

    assertEquals("Film rating is invalid", throwable.getMessage());
  }

  @Test
  void invalidGrossTest() {
    Throwable throwable = assertThrows(InvalidGross.class,
        () -> GrossValidationRule.validate("19515.151"));

    assertEquals("Gross is invalid. Gross must be a whole number.", throwable.getMessage());
  }

  @Test
  void invalidNameTest() {
    Throwable throwable = assertThrows(InvalidNameException.class,
        () -> NameValidationRule.validate(""));

    assertEquals("Name is invalid.", throwable.getMessage());
  }

  @Test
  void invalidNameNullTest() {
    Throwable throwable = assertThrows(InvalidNameException.class,
        () -> NameValidationRule.validate(null));

    assertEquals("Name is invalid.", throwable.getMessage());
  }

  @Test
  void invalidGenreTest() {
    Throwable throwable = assertThrows(InvalidGenreException.class,
        () -> GenreValidationRule.validate("Invalid movies genre"));

    assertEquals("Invalid movies genre", throwable.getMessage());
  }

  @Test
  void invalidLanguageTest() {
    Throwable throwable = assertThrows(InvalidLanguageException.class,
        () -> LanguageValidationRule.validate(""));

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