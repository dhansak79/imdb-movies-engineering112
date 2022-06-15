package com.spartaglobal.moviesapi.controller;

import com.spartaglobal.moviesapi.enums.AgeRating;
import com.spartaglobal.moviesapi.enums.Genre;
import com.spartaglobal.moviesapi.exceptions.ValidateException;
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

public class DataValidation {

  public static boolean validateData(String[] array) {
    try {
      isValidLength(array);
      isValidTitle(array[0]);
      isValidScore(array[1]);
      isValidYear(array[2]);
      isValidDuration(array[3]);
      isValidRating(array[4]);
      isValidBudget(array[5]);
      isValidGenre(array[6]);
      isValidGross(array[7]);
      isValidName(array[8]);
      isValidName(array[9]);
      isValidName(array[10]);
      isValidName(array[11]);
      isValidLanguage(array[12]);
      isValidCountry(array[13]);
    } catch (ValidateException ve) {
      return false;
    }

    return true;
  }


  public static boolean isValidLength(String[] arr) throws ValidateException {
    if (arr.length != 14) {
      throw new InvalidLengthException();
    }
    return true;
  }


  public static boolean isValidTitle(String input) throws ValidateException {
    if (input.length() <= 0) {
      throw new InvalidTitleException();
    }
    return true;
  }

  public static boolean isValidScore(String input) throws ValidateException {
    try {
      Double.parseDouble(input);
    } catch (NumberFormatException nfe) {
      throw new InvalidScoreException();
    }
    return true;
  }

  public static boolean isValidDuration(String input) throws ValidateException {
    try {
      Integer.parseInt(input);
    } catch (NumberFormatException nfe) {
      throw new InvalidDurationException();
    }
    return true;
  }

  public static boolean isValidYear(String input) throws ValidateException {
    if (input.length() != 4) {
      throw new InvalidYearException();
    }
    try {
      Integer.parseInt(input);
    } catch (NumberFormatException nfe) {
      throw new InvalidYearException();
    }
    return true;
  }

  public static boolean isValidRating(String input) throws ValidateException {
    if (AgeRating.getRatingFromString(input) == null) {
      throw new InvalidRatingException();
    }
    return true;
  }

  public static boolean isValidBudget(String budget) throws InvalidBudgetException {
    try {
      Long.parseLong(budget);
    } catch (NumberFormatException nfe) {
      throw new InvalidBudgetException();
    }
    return true;
  }

  public static boolean isValidGross(String input) throws ValidateException {
    try {
      Long.parseLong(input);
    } catch (NumberFormatException nfe) {
      throw new InvalidGross();
    }
    return true;
  }

  public static boolean isValidName(String input) throws ValidateException {
    if (input == null) {
      throw new InvalidNameException();
    }

    if (input.length() <= 0) {
      throw new InvalidNameException();
    }

    return true;
  }

  public static boolean isValidGenre(String input) throws ValidateException {
    String[] genres = input.split("\\|");
    for (String s : genres) {
      if (Genre.getGenreFromString(s) == null) {
        throw new InvalidGenreException();
      }
    }
    return true;
  }

  public static boolean isValidLanguage(String input) throws ValidateException {
    if (input == null || input.length() <= 2) {
      throw new InvalidLanguageException();
    }
    return true;
  }

  public static boolean isValidCountry(String input) throws ValidateException {
    if (input == null || input.length() < 2) {
      throw new InvalidCountryException();
    }
    return true;
  }
}
