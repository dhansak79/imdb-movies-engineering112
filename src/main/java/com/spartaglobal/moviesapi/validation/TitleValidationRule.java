package com.spartaglobal.moviesapi.validation;

import com.spartaglobal.moviesapi.exceptions.ValidateException;
import com.spartaglobal.moviesapi.exceptions.ValidateMoviesException.InvalidTitleException;

public class TitleValidationRule {

  public static boolean validate(String input) throws ValidateException {
    if (input.length() <= 0) {
      throw new InvalidTitleException();
    }
    return true;
  }
}
