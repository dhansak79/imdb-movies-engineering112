package com.spartaglobal.moviesapi.filehandling.validation;

import com.spartaglobal.moviesapi.filehandling.validation.exceptions.ValidateException;
import com.spartaglobal.moviesapi.filehandling.validation.exceptions.ValidateMoviesException.InvalidNameException;

public class ActorsNamesValidationRule implements FilmValidationRule {

  public void validate(FilmCsvRow film) throws ValidateException {
    for (String actor : film.getActors()) {
      if (actor == null || actor.length() < 1) {
        throw new InvalidNameException();
      }
    }
  }
}
