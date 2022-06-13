package com.spartaglobal.moviesapi.controller.ValidationInterfaces;

import com.spartaglobal.moviesapi.exceptions.ValidateException;

public interface ValidateScore {

  static boolean isValidScore(String input) throws ValidateException {
    return false;
  }
}
