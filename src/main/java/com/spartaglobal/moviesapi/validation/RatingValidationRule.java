package com.spartaglobal.moviesapi.validation;

import com.spartaglobal.moviesapi.exceptions.ValidateException;
import com.spartaglobal.moviesapi.exceptions.ValidateMoviesException.InvalidRatingException;
import com.spartaglobal.moviesapi.model.enums.AgeRating;

public class RatingValidationRule {

  public static boolean validate(String input) throws ValidateException {
    if (AgeRating.getRatingFromString(input) == null) {
      throw new InvalidRatingException();
    }
    return true;
  }
}
