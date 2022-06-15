package com.spartaglobal.moviesapi.validation;

import com.spartaglobal.moviesapi.exceptions.ValidateException;
import com.spartaglobal.moviesapi.exceptions.ValidateMoviesException.InvalidGenreException;
import com.spartaglobal.moviesapi.model.enums.Genre;

public class GenreValidationRule {

  public static boolean validate(String input) throws ValidateException {
    String[] genres = input.split("\\|");
    for (String s : genres) {
      if (Genre.getGenreFromString(s) == null) {
        throw new InvalidGenreException();
      }
    }
    return true;
  }
}
