package com.spartaglobal.moviesapi.validation;

import com.spartaglobal.moviesapi.exceptions.ValidateException;
import com.spartaglobal.moviesapi.exceptions.ValidateMoviesException.InvalidCountryException;

public class CountryValidationRule implements FilmValidationRule {

  public void validate(FilmCsvRow film) throws ValidateException {
    if (film.getCountry() == null || film.getCountry().length() < 2) {
      throw new InvalidCountryException();
    }
  }
}
