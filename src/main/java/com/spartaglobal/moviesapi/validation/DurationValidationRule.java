package com.spartaglobal.moviesapi.validation;

import com.spartaglobal.moviesapi.exceptions.ValidateException;
import com.spartaglobal.moviesapi.exceptions.ValidateMoviesException.InvalidDurationException;

public class DurationValidationRule implements FilmValidationRule {

  public void validate(FilmCsvRow film) throws ValidateException {
    try {
      Integer.parseInt(film.getDuration());
    } catch (NumberFormatException nfe) {
      throw new InvalidDurationException();
    }
  }
}
