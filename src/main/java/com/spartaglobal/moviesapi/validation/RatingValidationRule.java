package com.spartaglobal.moviesapi.validation;

import com.spartaglobal.moviesapi.exceptions.ValidateException;
import com.spartaglobal.moviesapi.exceptions.ValidateMoviesException.InvalidRatingException;
import com.spartaglobal.moviesapi.model.enums.AgeRating;

public class RatingValidationRule implements FilmValidationRule {

  public void validate(FilmCsvRow film) throws ValidateException {
    if (AgeRating.getRatingFromString(film.getRating()) == null) {
      throw new InvalidRatingException();
    }
  }
}
