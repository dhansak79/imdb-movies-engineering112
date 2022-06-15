package com.spartaglobal.moviesapi.validation;

import com.spartaglobal.moviesapi.validation.exceptions.ValidateException;
import com.spartaglobal.moviesapi.validation.exceptions.ValidateMoviesException.InvalidYearException;

public class YearValidationRule implements FilmValidationRule {

  public void validate(FilmCsvRow film) throws ValidateException {
    if (film.getYear().length() != 4) {
      throw new InvalidYearException();
    }
    try {
      Integer.parseInt(film.getYear());
    } catch (NumberFormatException nfe) {
      throw new InvalidYearException();
    }
  }
}
