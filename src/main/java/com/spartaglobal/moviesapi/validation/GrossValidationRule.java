package com.spartaglobal.moviesapi.validation;

import com.spartaglobal.moviesapi.validation.exceptions.ValidateException;
import com.spartaglobal.moviesapi.validation.exceptions.ValidateMoviesException.InvalidGross;

public class GrossValidationRule implements FilmValidationRule {

  public void validate(FilmCsvRow film) throws ValidateException {
    try {
      Long.parseLong(film.getGross());
    } catch (NumberFormatException nfe) {
      throw new InvalidGross();
    }
  }
}
