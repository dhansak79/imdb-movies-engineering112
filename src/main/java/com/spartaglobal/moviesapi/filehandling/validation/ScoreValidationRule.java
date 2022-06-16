package com.spartaglobal.moviesapi.filehandling.validation;

import com.spartaglobal.moviesapi.filehandling.validation.exceptions.ValidateException;
import com.spartaglobal.moviesapi.filehandling.validation.exceptions.ValidateMoviesException.InvalidScoreException;

public class ScoreValidationRule implements FilmValidationRule {

  public void validate(FilmCsvRow filmCsvRow) throws ValidateException {
    try {
      Double.parseDouble(filmCsvRow.getScore());
    } catch (NumberFormatException nfe) {
      throw new InvalidScoreException();
    }
  }
}
