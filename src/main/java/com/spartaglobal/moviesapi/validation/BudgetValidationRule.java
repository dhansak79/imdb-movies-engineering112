package com.spartaglobal.moviesapi.validation;

import com.spartaglobal.moviesapi.validation.exceptions.ValidateMoviesException.InvalidBudgetException;

public class BudgetValidationRule implements FilmValidationRule {

  public void validate(FilmCsvRow film) throws InvalidBudgetException {
    try {
      Long.parseLong(film.getBudget());
    } catch (NumberFormatException nfe) {
      throw new InvalidBudgetException();
    }
  }
}
