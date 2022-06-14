package com.spartaglobal.moviesapi.model;


import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Film {

  private String title;
  private double score;
  private int year;
  private int duration;
  private String rating;
  private long budget;
  private String genre;
  private long gross;
  private String director;
  private String actor1;
  private String actor2;
  private String actor3;
  private String language;
  private String country;

  public Film(String title, double score, int year, int duration, String rating, long budget,
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
    this.language = language;
    this.country = country;
  }

  public String getTitle() {
    return title;
  }

  public double getScore() {
    return score;
  }

  public int getYear() {
    return year;
  }

  public int getDuration() {
    return duration;
  }

  public String getRating() {
    return rating;
  }

  public long getBudget() {
    return budget;
  }

  public String getGenre() {
    return genre;
  }

  public long getGross() {
    return gross;
  }

  public String getDirector() {
    return director;
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