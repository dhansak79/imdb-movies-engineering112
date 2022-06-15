package com.spartaglobal.moviesapi.validation;

import com.spartaglobal.moviesapi.exceptions.ValidateException;
import com.spartaglobal.moviesapi.exceptions.ValidateMoviesException.InvalidNameException;

public class NameValidationRule {

  public static boolean validate(String input) throws ValidateException {
    if (input == null) {
      throw new InvalidNameException();
    }

    if (input.length() <= 0) {
      throw new InvalidNameException();
    }

    return true;
  }
}
