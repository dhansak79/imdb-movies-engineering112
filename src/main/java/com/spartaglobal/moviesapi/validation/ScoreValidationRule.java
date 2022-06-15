package com.spartaglobal.moviesapi.validation;

import com.spartaglobal.moviesapi.exceptions.ValidateException;
import com.spartaglobal.moviesapi.exceptions.ValidateMoviesException.InvalidScoreException;

public class ScoreValidationRule {

  public static boolean validate(String input) throws ValidateException {
    try {
      Double.parseDouble(input);
    } catch (NumberFormatException nfe) {
      throw new InvalidScoreException();
    }
    return true;
  }
}
