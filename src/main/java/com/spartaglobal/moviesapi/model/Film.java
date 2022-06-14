package com.spartaglobal.moviesapi.model;

import com.spartaglobal.moviesapi.enums.Genre;
import java.time.LocalDate;
import java.util.List;
import lombok.Data;


@Data
public record Film(String title, boolean score, LocalDate year, int duration, String rating,
  long budget, String genre, long gross, String director, String actor1, String actor2,
  String actor3, String Language, String country

                   //  DateTimeFormatter format = new DateTimeFormatterBuilder()
//      .appendPattern("yyyy")
//      .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
//      .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
//      .toFormatter();
//
//  private LocalDate year = LocalDate.parse("2008", format);
//)
) {}
