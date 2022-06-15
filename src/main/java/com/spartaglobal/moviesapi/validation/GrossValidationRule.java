package com.spartaglobal.moviesapi.validation;

import com.spartaglobal.moviesapi.exceptions.ValidateException;
import com.spartaglobal.moviesapi.exceptions.ValidateMoviesException.InvalidGross;

public class GrossValidationRule {

  public static boolean validate(String input) throws ValidateException {
    try {
      Long.parseLong(input);
    } catch (NumberFormatException nfe) {
      throw new InvalidGross();
    }
    return true;
  }
}
