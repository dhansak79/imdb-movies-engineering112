package com.spartaglobal.moviesapi.dao;

import static org.junit.jupiter.api.Assertions.*;

import com.spartaglobal.moviesapi.model.Film;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import org.junit.jupiter.api.Test;

class ImdbFilmDaoTest {
  FilmDao filmDao = new ImdbFilmDao();
    DateTimeFormatter format = new DateTimeFormatterBuilder()
      .appendPattern("yyyy")
      .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
      .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
      .toFormatter();

  private LocalDate year = LocalDate.parse("2009", format);
  Film film = new Film("Avatar",	7.9,	2009,	178, 	"PG-13",	237000000,
      "Action|Adventure|Fantasy|Sci-Fi",	760505847,	"James Cameron",
      "CCH Pounder", "Joel David Moore", "Wes Studi",	"English",	"USA"
);
  @Test
  void addToDbTest() {
    filmDao.save(film);
  }

}