package com.spartaglobal.moviesapi.validation;

import com.spartaglobal.moviesapi.exceptions.ValidateException;

public interface FilmValidationRule {

  void validate(FilmCsvRow filmCsvRow) throws ValidateException;

}
