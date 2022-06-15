package com.spartaglobal.moviesapi.validation;

import com.spartaglobal.moviesapi.validation.exceptions.ValidateException;
import com.spartaglobal.moviesapi.validation.exceptions.ValidateMoviesException.InvalidLanguageException;

public class LanguageValidationRule implements FilmValidationRule {

  public void validate(FilmCsvRow film) throws ValidateException {
    if (film.getLanguage() == null || film.getLanguage().length() <= 2) {
      throw new InvalidLanguageException();
    }
  }
}
