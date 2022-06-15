package com.spartaglobal.moviesapi.controller;

import com.spartaglobal.moviesapi.exceptions.ValidateException;
import com.spartaglobal.moviesapi.validation.BudgetValidationRule;
import com.spartaglobal.moviesapi.validation.CountryValidationRule;
import com.spartaglobal.moviesapi.validation.FilmCsvRow;
import com.spartaglobal.moviesapi.validation.FilmValidationRule;
import com.spartaglobal.moviesapi.validation.YearValidationRule;
import java.util.ArrayList;
import java.util.List;

public class DataValidator {

  public static boolean validateData(String[] array) {
    FilmCsvRow film = new FilmCsvRow(array[0], array[1], array[2], array[3], array[4],
        array[5], array[6], array[7], array[8], array[9], array[10], array[11], array[12],
        array[13]);

    List<FilmValidationRule> rules = new ArrayList<>();
    rules.add(new BudgetValidationRule());
    rules.add(new YearValidationRule());
    rules.add(new CountryValidationRule());

    for (FilmValidationRule rule : rules) {
      try {
        rule.validate(film);
      } catch (ValidateException e) {
        return false;
      }
    }
    return true;
  }


}
