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

class DataValidationTest {

  private static final String[] VALID_DATA_SAMPLE = {"Avatar", "7.9", "2009", "178", "PG-13",
      "237000000", "Action|Adventure|Fantasy|Sci-Fi", "760505847", "James Cameron", "CCH Pounder",
      "Joel David Moore", "Wes Studi", "English", "USA"};

  // Intentionally removed Movie Title to create invalid data length
  private static final String[] INVALID_DATA_LENGTH_SAMPLE = {"7.9", "2009", "178", "PG-13",
      "237000000", "Action|Adventure|Fantasy|Sci-Fi", "760505847", "James Cameron", "CCH Pounder",
      "Joel David Moore", "Wes Studi", "English", "USA"};

  @Test
  void validDataTest() {
    Assertions.assertTrue(DataValidation.validateData(VALID_DATA_SAMPLE));
  }

  @Test
  void invalidDataLengthTest() {
    Throwable throwable = assertThrows(InvalidLengthException.class, () ->
        DataValidation.isValidLength(INVALID_DATA_LENGTH_SAMPLE));

    assertEquals("Incomplete length of data", throwable.getMessage());
  }

  @Test
  void invalidTitleTest() {
    Throwable throwable = assertThrows(InvalidTitleException.class, () ->
        DataValidation.isValidTitle(""));

    assertEquals("Invalid movie title", throwable.getMessage());
  }

  @Test
  void invalidScoreTest() {
    Throwable throwable = assertThrows(InvalidScoreException.class, () ->
        DataValidation.isValidScore("seven"));

    assertEquals("Invalid score", throwable.getMessage());
  }

  @Test
  void invalidYearTest() {
    Throwable throwable = assertThrows(InvalidYearException.class, () ->
        DataValidation.isValidYear("202"));

    assertEquals("Film year is invalid", throwable.getMessage());
  }

  @Test
  void invalidDurationTest() {
    Throwable throwable = assertThrows(InvalidDurationException.class, () ->
        DataValidation.isValidDuration("199.1452"));

    assertEquals("Invalid duration. Duration must be a whole number.", throwable.getMessage());
  }

  @Test
  void invalidBudgetAsTextTest() {
    Throwable throwable = assertThrows(InvalidBudgetException.class, () ->
        DataValidation.isValidBudget("budget"));

    assertEquals("Budget must be a whole number", throwable.getMessage());
  }

  @Test
  void invalidBudgetAsNotWholeNumberTest() {
    Throwable throwable = assertThrows(InvalidBudgetException.class, () ->
        DataValidation.isValidBudget("1.25454"));
    assertEquals("Budget must be a whole number", throwable.getMessage());
  }

  @Test
  void invalidRatingTest() {
    Throwable throwable = assertThrows(InvalidRatingException.class,
        () -> DataValidation.isValidRating("6713"));

    assertEquals("Film rating is invalid", throwable.getMessage());
  }

  @Test
  void invalidGrossTest() {
    Throwable throwable = assertThrows(InvalidGross.class,
        () -> DataValidation.isValidGross("19515.151"));

    assertEquals("Gross is invalid. Gross must be a whole number.", throwable.getMessage());
  }

  @Test
  void invalidNameTest() {
    Throwable throwable = assertThrows(InvalidNameException.class,
        () -> DataValidation.isValidName(""));

    assertEquals("Name is invalid.", throwable.getMessage());
  }

  @Test
  void invalidGenreTest() {
    Throwable throwable = assertThrows(InvalidGenreException.class,
        () -> DataValidation.isValidGenre("Invalid movies genre"));

    assertEquals("Invalid movies genre", throwable.getMessage());
  }

  @Test
  void invalidLanguageTest() {
    Throwable throwable = assertThrows(InvalidLanguageException.class,
        () -> DataValidation.isValidLanguage(""));

    assertEquals("Invalid Language Detected", throwable.getMessage());
  }

  @Test
  void invalidCountryTest() {
    Throwable throwable = assertThrows(InvalidCountryException.class,
        () -> DataValidation.isValidCountry(""));

    assertEquals("Invalid Country detected", throwable.getMessage());
  }

}