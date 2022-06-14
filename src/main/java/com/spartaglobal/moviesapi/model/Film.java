package com.spartaglobal.moviesapi.model;

import com.spartaglobal.moviesapi.enums.Genre;
import java.time.LocalDate;
import java.util.List;
import lombok.Data;

@Data
public class Film {

  private String title;
  private boolean score;
//  DateTimeFormatter format = new DateTimeFormatterBuilder()
//      .appendPattern("yyyy")
//      .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
//      .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
//      .toFormatter();
//
//  private LocalDate year = LocalDate.parse("2008", format);
  private LocalDate year;
  private int duration;
  private String rating;
  private long budget;
  private Genre genre;
  private List<Genre> genres;
  private long gross;
  private String director;
  private String actor1;
  private String actor2;
  private String actor3;
  private String Language;
  private String country;

}
