package com.spartaglobal.moviesapi.model;

import com.spartaglobal.moviesapi.enums.Genre;
import java.time.LocalDate;
import java.util.List;
import lombok.Data;

@Data
public record Film(String title, boolean score, LocalDate year, int duration, String rating,
  long budget) {}
//  private Genre genre;
//  private List<Genre> genres;
//  private long gross;
//  private String director;
//  private String actor1;
//  private String actor2;
//  private String actor3;
//  private String Language;
//  private String country;

                   //  DateTimeFormatter format = new DateTimeFormatterBuilder()
//      .appendPattern("yyyy")
//      .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
//      .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
//      .toFormatter();
//
//  private LocalDate year = LocalDate.parse("2008", format);
//)
