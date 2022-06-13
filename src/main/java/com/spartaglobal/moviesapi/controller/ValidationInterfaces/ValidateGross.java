package com.spartaglobal.moviesapi.controller.ValidationInterfaces;

import com.spartaglobal.moviesapi.exceptions.ValidateException;
import com.spartaglobal.moviesapi.exceptions.ValidateMoviesException.InvalidBudgetException;

public interface ValidateGross {

  static boolean isValidGross(String input) throws ValidateException {
    return false;
  }
}
