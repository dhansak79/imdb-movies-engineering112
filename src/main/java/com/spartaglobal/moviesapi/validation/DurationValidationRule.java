package com.spartaglobal.moviesapi.validation;

import com.spartaglobal.moviesapi.exceptions.ValidateException;
import com.spartaglobal.moviesapi.exceptions.ValidateMoviesException.InvalidDurationException;

public class DurationValidationRule {

  public static boolean validate(String input) throws ValidateException {
    try {
      Integer.parseInt(input);
    } catch (NumberFormatException nfe) {
      throw new InvalidDurationException();
    }
    return true;
  }
}
