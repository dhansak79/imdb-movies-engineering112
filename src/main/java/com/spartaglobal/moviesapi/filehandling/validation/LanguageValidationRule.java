package com.spartaglobal.moviesapi.filehandling.validation;

import com.spartaglobal.moviesapi.filehandling.validation.exceptions.ValidateException;
import com.spartaglobal.moviesapi.filehandling.validation.exceptions.ValidateMoviesException.InvalidLanguageException;

public class LanguageValidationRule implements FilmValidationRule {

  public void validate(FilmCsvRow film) throws ValidateException {
    if (film.getLanguage() == null || film.getLanguage().length() <= 2) {
      throw new InvalidLanguageException();
    }
  }
}
