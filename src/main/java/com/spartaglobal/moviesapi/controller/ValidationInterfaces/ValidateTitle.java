package com.spartaglobal.moviesapi.controller.ValidationInterfaces;

import com.spartaglobal.moviesapi.exceptions.ValidateException;

public interface ValidateTitle {

  static boolean isValidTitle(String input) throws ValidateException {
    return false;
  }

}
