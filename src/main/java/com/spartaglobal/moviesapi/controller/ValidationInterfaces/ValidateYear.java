package com.spartaglobal.moviesapi.controller.ValidationInterfaces;

import com.spartaglobal.moviesapi.exceptions.ValidateException;

public interface ValidateYear {

  static boolean isValidYear(String input) throws ValidateException {
    return false;
  }
}
