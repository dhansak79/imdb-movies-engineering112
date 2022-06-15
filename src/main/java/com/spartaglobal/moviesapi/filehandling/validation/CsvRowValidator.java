package com.spartaglobal.moviesapi.filehandling.validation;

import com.spartaglobal.moviesapi.filehandling.validation.exceptions.ValidateException;
import java.util.ArrayList;
import java.util.List;

public class CsvRowValidator {

  public static boolean validateData(String[] csvRow) {
    if (csvRow.length != 14) {
      return false;
    }

    FilmCsvRow film = new FilmCsvRow(csvRow[0], csvRow[1], csvRow[2], csvRow[3], csvRow[4],
        csvRow[5], csvRow[6], csvRow[7], csvRow[8], csvRow[9], csvRow[10], csvRow[11], csvRow[12],
        csvRow[13]);

    List<FilmValidationRule> rules = new ArrayList<>();
    rules.add(new BudgetValidationRule());
    rules.add(new CountryValidationRule());
    rules.add(new DurationValidationRule());
    rules.add(new GenreValidationRule());
    rules.add(new GrossValidationRule());
    rules.add(new LanguageValidationRule());
    rules.add(new ActorsNamesValidationRule());
    rules.add(new RatingValidationRule());
    rules.add(new ScoreValidationRule());
    rules.add(new TitleValidationRule());
    rules.add(new YearValidationRule());

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
