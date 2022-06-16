package com.spartaglobal.moviesapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "films")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Film {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false, name = "film_id")
  private long id;
  @Column(nullable = false, length = 100)
  private String title;
  @Column(nullable = false)
  private double score;
  @Column(nullable = false, name = "release_year")
  private int year;
  @Column(nullable = false)
  private int duration;
  @Column(nullable = false, length = 10)
  private String rating;
  @Column(nullable = false)
  private long budget;
  @Column(nullable = false, length = 250, name = "genres")
  // Might need to be string for interaction with the DB
  private String genre;
  @Column(nullable = false)
  private long gross;
  @Column(nullable = false, length = 150)
  private String director;
  @Column(nullable = false, length = 150)
  private String actor1;
  @Column(nullable = false, length = 150)
  private String actor2;
  @Column(nullable = false, length = 150)
  private String actor3;
  @Column(nullable = false, length = 60, name = "film_language")
  private String language;
  @Column(nullable = false, length = 70)
  private String country;

  public Film(long id, String title, double score, int year, int duration, String rating,
      long budget, String genre, long gross, String director, String actor1, String actor2,
      String actor3, String language, String country) {
    this.id = id;
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

  public Film(String title, double score, int year, int duration, String rating,
      long budget, String genre, long gross, String director, String actor1, String actor2,
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
}


