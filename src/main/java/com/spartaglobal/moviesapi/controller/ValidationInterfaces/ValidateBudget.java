package com.spartaglobal.moviesapi.controller.ValidationInterfaces;

import com.spartaglobal.moviesapi.exceptions.ValidateMoviesException.InvalidBudgetException;

public interface ValidateBudget {

  static boolean isValidBudget(String budget) throws InvalidBudgetException {
    return false;
  }
}
