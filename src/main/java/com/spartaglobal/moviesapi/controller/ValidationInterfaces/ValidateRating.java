package com.spartaglobal.moviesapi.controller.ValidationInterfaces;

import com.spartaglobal.moviesapi.exceptions.ValidateException;

public interface ValidateRating {

  static boolean isValidRating(String input) throws ValidateException {
    return false;
  }
}
