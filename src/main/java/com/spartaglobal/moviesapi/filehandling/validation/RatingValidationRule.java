package com.spartaglobal.moviesapi.filehandling.validation;

import com.spartaglobal.moviesapi.filehandling.validation.exceptions.ValidateException;
import com.spartaglobal.moviesapi.filehandling.validation.exceptions.ValidateMoviesException.InvalidRatingException;
import com.spartaglobal.moviesapi.model.enums.AgeRating;

public class RatingValidationRule implements FilmValidationRule {

  public void validate(FilmCsvRow film) throws ValidateException {
    if (AgeRating.getRatingFromString(film.getRating()) == null) {
      throw new InvalidRatingException();
    }
  }
}
