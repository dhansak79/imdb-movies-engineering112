package com.spartaglobal.moviesapi.controller.ValidationInterfaces;

import com.spartaglobal.moviesapi.exceptions.ValidateException;

public interface ValidateName {

  static boolean isValidName(String input) throws ValidateException {
    return false;
  }
}
