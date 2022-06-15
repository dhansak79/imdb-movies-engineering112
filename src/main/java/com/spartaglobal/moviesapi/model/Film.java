package com.spartaglobal.moviesapi.model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "films")
@NoArgsConstructor
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

  public long getId() {
    return id;
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

  public void setId(long id) {
    this.id = id;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setScore(double score) {
    this.score = score;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public void setDuration(int duration) {
    this.duration = duration;
  }

  public void setRating(String rating) {
    this.rating = rating;
  }

  public void setBudget(long budget) {
    this.budget = budget;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  public void setGross(long gross) {
    this.gross = gross;
  }

  public void setDirector(String director) {
    this.director = director;
  }

  public void setActor1(String actor1) {
    this.actor1 = actor1;
  }

  public void setActor2(String actor2) {
    this.actor2 = actor2;
  }

  public void setActor3(String actor3) {
    this.actor3 = actor3;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Film)) {
      return false;
    }
    Film film = (Film) o;
    return id == film.id && score == film.score && duration == film.duration
        && budget == film.budget && gross == film.gross && title.equals(film.title)
        && year == film.year && rating.equals(film.rating) && genre.equals(film.genre)
        && director.equals(film.director) && actor1.equals(film.actor1) && actor2.equals(
        film.actor2) && actor3.equals(film.actor3) && language.equals(film.language)
        && country.equals(film.country);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, score, year, duration, rating, budget, genre, gross, director,
        actor1, actor2, actor3, language, country);
  }

  @Override
  public String toString() {
    return "FilmDto{" +
        "id=" + id +
        ", title='" + title + '\'' +
        ", score=" + score +
        ", year=" + year +
        ", duration=" + duration +
        ", rating='" + rating + '\'' +
        ", budget=" + budget +
        ", genre='" + genre + '\'' +
        ", gross=" + gross +
        ", director='" + director + '\'' +
        ", actor1='" + actor1 + '\'' +
        ", actor2='" + actor2 + '\'' +
        ", actor3='" + actor3 + '\'' +
        ", Language='" + language + '\'' +
        ", country='" + country + '\'' +
        '}';
  }
}


