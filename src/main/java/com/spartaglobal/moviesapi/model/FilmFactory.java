package com.spartaglobal.moviesapi.model;

import com.spartaglobal.moviesapi.model.Film;

public class FilmFactory {

  public Film createFilm(String[] filmString) {
    String title = filmString[0];
    double score = Double.parseDouble(filmString[1]);
    int year = Integer.parseInt(filmString[2]);
    int duration = Integer.parseInt(filmString[3]);
    String rating = filmString[4];
    long budget = Long.parseLong(filmString[5]);
    String genre = filmString[6];
    long gross = Long.parseLong(filmString[7]);
    String director = filmString[8];
    String actor1 = filmString[9];
    String actor2 = filmString[10];
    String actor3 = filmString[11];
    String language = filmString[12];
    String country = filmString[13];

    return new Film(title, score, year, duration, rating, budget, genre, gross, director, actor1,
        actor2, actor3, language, country);

  }
}
