package com.spartaglobal.moviesapi.validation;

import com.spartaglobal.moviesapi.exceptions.ValidateException;
import com.spartaglobal.moviesapi.exceptions.ValidateMoviesException.InvalidGenreException;
import com.spartaglobal.moviesapi.model.enums.Genre;

public class GenreValidationRule implements FilmValidationRule {

  public void validate(FilmCsvRow films) throws ValidateException {
    String[] genres = films.getGenre().split("\\|");
    for (String s : genres) {
      if (Genre.getGenreFromString(s) == null) {
        throw new InvalidGenreException();
      }
    }
  }
}
