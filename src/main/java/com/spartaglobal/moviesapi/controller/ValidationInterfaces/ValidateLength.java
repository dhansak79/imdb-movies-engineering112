package com.spartaglobal.moviesapi.controller.ValidationInterfaces;

import com.spartaglobal.moviesapi.exceptions.ValidateException;

public interface ValidateLength {

  static boolean isValidLength(String[] arr) throws ValidateException {
    return false;
  }
}
