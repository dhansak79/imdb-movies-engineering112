package com.spartaglobal.moviesapi.filehandling.validation;

import com.spartaglobal.moviesapi.filehandling.validation.exceptions.ValidateException;
import com.spartaglobal.moviesapi.filehandling.validation.exceptions.ValidateMoviesException.InvalidDurationException;

public class DurationValidationRule implements FilmValidationRule {

  public void validate(FilmCsvRow film) throws ValidateException {
    try {
      Integer.parseInt(film.getDuration());
    } catch (NumberFormatException nfe) {
      throw new InvalidDurationException();
    }
  }
}
