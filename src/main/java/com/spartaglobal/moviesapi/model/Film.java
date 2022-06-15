package com.spartaglobal.moviesapi.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Film {
  private String title;
  private double score;
  private int year;
  private int duration;
  private String rating;
  private long budget;
  // Might need to be string for interaction with the DB
  private String genre;
  private long gross;
  private String director;
  private String actor1;
  private String actor2;
  private String actor3;
  private String Language;
  private String country;

  public Film(String title, double score, int year, int duration, String rating,
      long budget,
      String genre, long gross, String director, String actor1, String actor2, String actor3,
      String language, String country) {
    this.title = title;
    this.score = score;
    this.year = year;
    this.duration = duration;
    this.rating = rating;
    this.budget = budget;
    this.genre = genre;
    this.gross = gross;
    this.director = director;
    this.actor1 = actor1;
    this.actor2 = actor2;
    this.actor3 = actor3;
    Language = language;
    this.country = country;
  }
}
