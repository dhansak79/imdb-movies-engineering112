package com.spartaglobal.moviesapi.validation;

import com.spartaglobal.moviesapi.exceptions.ValidateException;
import com.spartaglobal.moviesapi.exceptions.ValidateMoviesException.InvalidTitleException;

public class TitleValidationRule implements FilmValidationRule {

  public void validate(FilmCsvRow film) throws ValidateException {
    if (film.getTitle().length() <= 0) {
      throw new InvalidTitleException();
    }
  }
}
