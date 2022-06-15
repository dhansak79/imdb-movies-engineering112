package com.spartaglobal.moviesapi.validation;

import com.spartaglobal.moviesapi.exceptions.ValidateException;
import com.spartaglobal.moviesapi.exceptions.ValidateMoviesException.InvalidLengthException;

public class LengthValidationRule {

  public static boolean validate(String[] arr) throws ValidateException {
    if (arr.length != 14) {
      throw new InvalidLengthException();
    }
    return true;
  }
}
