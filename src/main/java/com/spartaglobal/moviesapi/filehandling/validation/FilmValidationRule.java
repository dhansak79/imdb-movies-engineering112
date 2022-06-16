package com.spartaglobal.moviesapi.filehandling.validation;

import com.spartaglobal.moviesapi.filehandling.validation.exceptions.ValidateException;

public interface FilmValidationRule {

  void validate(FilmCsvRow filmCsvRow) throws ValidateException;

}
