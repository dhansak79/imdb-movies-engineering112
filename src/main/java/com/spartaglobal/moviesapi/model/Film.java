package com.spartaglobal.moviesapi.model;

import java.time.LocalDate;


public record Film(String title, double score, LocalDate year, int duration, String rating,
  long budget, String genre, long gross, String director, String actor1, String actor2,
  String actor3, String language, String country) {

  public void setTitle(String title) {
  }
}
