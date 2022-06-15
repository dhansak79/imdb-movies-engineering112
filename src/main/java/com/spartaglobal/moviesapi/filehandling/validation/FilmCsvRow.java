package com.spartaglobal.moviesapi.filehandling.validation;

import java.util.List;

public class FilmCsvRow {

  private String title;

  private String score;
  private String year;
  private String duration;
  private String rating;
  private String budget;
  private String genre;
  private String gross;
  private String director;
  private String actor1;
  private String actor2;
  private String actor3;
  private String language;
  private String country;

  public FilmCsvRow(String title, String score, String year, String duration, String rating,
      String budget, String genre, String gross, String director, String actor1, String actor2,
      String actor3, String language, String country) {
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
    this.language = language;
    this.country = country;
  }

  public String getTitle() {
    return title;
  }

  public String getScore() {
    return score;
  }

  public String getYear() {
    return year;
  }

  public String getDuration() {
    return duration;
  }

  public String getRating() {
    return rating;
  }

  public String getBudget() {
    return budget;
  }

  public String getGenre() {
    return genre;
  }

  public String getGross() {
    return gross;
  }

  public String getDirector() {
    return director;
  }

  public List<String> getActors() {
    return List.of(getActor1(), getActor2(), getActor3());
  }

  public String getActor1() {
    return actor1;
  }

  public String getActor2() {
    return actor2;
  }

  public String getActor3() {
    return actor3;
  }

  public String getLanguage() {
    return language;
  }

  public String getCountry() {
    return country;
  }
}
