package com.spartaglobal.moviesapi.validation;

import com.spartaglobal.moviesapi.exceptions.ValidateException;
import com.spartaglobal.moviesapi.exceptions.ValidateMoviesException.InvalidScoreException;

public class ScoreValidationRule implements FilmValidationRule {

  public void validate(FilmCsvRow filmCsvRow) throws ValidateException {
    try {
      Double.parseDouble(filmCsvRow.getScore());
    } catch (NumberFormatException nfe) {
      throw new InvalidScoreException();
    }
  }
}
