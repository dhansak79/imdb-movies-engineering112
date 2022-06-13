package com.spartaglobal.moviesapi.controller.ValidationInterfaces;

import com.spartaglobal.moviesapi.exceptions.ValidateException;

public interface ValidateDuration {

  static boolean isValidDuration(String input) throws ValidateException {
    return false;
  }
}
