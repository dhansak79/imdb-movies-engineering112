package com.spartaglobal.moviesapi.controller.ValidationInterfaces;

import com.spartaglobal.moviesapi.exceptions.ValidateException;

public interface ValidGenre {

  static boolean isValidGenre(String input) throws ValidateException {
    return false;
  }
}
