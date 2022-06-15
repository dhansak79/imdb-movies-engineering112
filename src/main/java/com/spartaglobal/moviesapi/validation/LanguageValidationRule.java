package com.spartaglobal.moviesapi.validation;

import com.spartaglobal.moviesapi.exceptions.ValidateException;
import com.spartaglobal.moviesapi.exceptions.ValidateMoviesException.InvalidLanguageException;

public class LanguageValidationRule {

  public static boolean validate(String input) throws ValidateException {
    if (input == null || input.length() <= 2) {
      throw new InvalidLanguageException();
    }
    return true;
  }
}
