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
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DataValidatorTest {

  private static final String[] VALID_DATA_SAMPLE = {"Avatar", "7.9", "2009", "178", "PG-13",
      "237000000", "Action|Adventure|Fantasy|Sci-Fi", "760505847", "James Cameron", "CCH Pounder",
      "Joel David Moore", "Wes Studi", "English", "USA"};

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
        DataValidator.isValidLength(INVALID_DATA_LENGTH_SAMPLE));

    assertEquals("Incomplete length of data", throwable.getMessage());
  }

  @Test
  void invalidTitleTest() {
    Throwable throwable = assertThrows(InvalidTitleException.class, () ->
        DataValidator.isValidTitle(""));

    assertEquals("Invalid movie title", throwable.getMessage());
  }

  @Test
  void invalidScoreTest() {
    Throwable throwable = assertThrows(InvalidScoreException.class, () ->
        DataValidator.isValidScore("seven"));

    assertEquals("Invalid score", throwable.getMessage());
  }

  @Test
  void invalidYearTest() {
    Throwable throwable = assertThrows(InvalidYearException.class, () ->
        DataValidator.isValidYear("202"));

    assertEquals("Film year is invalid", throwable.getMessage());
  }

  @Test
  void invalidYearNotANumberTest() {
    Throwable throwable = assertThrows(InvalidYearException.class, () ->
        DataValidator.isValidYear("aaaa"));

    assertEquals("Film year is invalid", throwable.getMessage());
  }

  @Test
  void invalidDurationTest() {
    Throwable throwable = assertThrows(InvalidDurationException.class, () ->
        DataValidator.isValidDuration("199.1452"));

    assertEquals("Invalid duration. Duration must be a whole number.", throwable.getMessage());
  }

  @Test
  void invalidBudgetAsTextTest() {
    Throwable throwable = assertThrows(InvalidBudgetException.class, () ->
        DataValidator.isValidBudget("budget"));

    assertEquals("Budget must be a whole number", throwable.getMessage());
  }

  @Test
  void invalidBudgetAsNotWholeNumberTest() {
    Throwable throwable = assertThrows(InvalidBudgetException.class, () ->
        DataValidator.isValidBudget("1.25454"));
    assertEquals("Budget must be a whole number", throwable.getMessage());
  }

  @Test
  void invalidRatingTest() {
    Throwable throwable = assertThrows(InvalidRatingException.class,
        () -> DataValidator.isValidRating("6713"));

    assertEquals("Film rating is invalid", throwable.getMessage());
  }

  @Test
  void invalidGrossTest() {
    Throwable throwable = assertThrows(InvalidGross.class,
        () -> DataValidator.isValidGross("19515.151"));

    assertEquals("Gross is invalid. Gross must be a whole number.", throwable.getMessage());
  }

  @Test
  void invalidNameTest() {
    Throwable throwable = assertThrows(InvalidNameException.class,
        () -> DataValidator.isValidName(""));

    assertEquals("Name is invalid.", throwable.getMessage());
  }

  @Test
  void invalidNameNullTest() {
    Throwable throwable = assertThrows(InvalidNameException.class,
        () -> DataValidator.isValidName(null));

    assertEquals("Name is invalid.", throwable.getMessage());
  }

  @Test
  void invalidGenreTest() {
    Throwable throwable = assertThrows(InvalidGenreException.class,
        () -> DataValidator.isValidGenre("Invalid movies genre"));

    assertEquals("Invalid movies genre", throwable.getMessage());
  }

  @Test
  void invalidLanguageTest() {
    Throwable throwable = assertThrows(InvalidLanguageException.class,
        () -> DataValidator.isValidLanguage(""));

    assertEquals("Invalid Language Detected", throwable.getMessage());
  }

  @Test
  void invalidCountryTest() {
    Throwable throwable = assertThrows(InvalidCountryException.class,
        () -> DataValidator.isValidCountry(""));

    assertEquals("Invalid Country detected", throwable.getMessage());
  }

}