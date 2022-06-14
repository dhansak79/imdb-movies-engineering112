package com.spartaglobal.moviesapi.dao;

import com.spartaglobal.moviesapi.controller.DbUtils;
import com.spartaglobal.moviesapi.model.Film;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ImdbFilmDao implements FilmDao{

  @Override
  public Optional get(int id) {
    return Optional.empty();
  }

  @Override
  public List<Film> getAll() throws SQLException {
    return null;
  }

  @Override
  public int save(Object o) {
    return 0;
  }

  @Override
  public int save(Film film) {
    String sqlStatement = """
        INSERT INTO films (
        film_id,
        title,
        score,
        release_year,
        duration,
        rating,
        budget,
        genres,
        gross,
        director,
        actor1,
        actor2,
        actor3,
        film_language,
        country)
        VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """;

    Object[] arguments = new Object[]{film.getTitle(), film.getScore(), film.getYear(),
    film.getDuration(), film.getRating(), film.getBudget(), film.getGenre(), film.getGross(),
    film.getDirector(), film.getActor1(), film.getActor2(), film.getActor3(), film.getLanguage(),
        film.getCountry()
    };

  return DbUtils.executeUpdate( sqlStatement, arguments );
  }

  @Override
  public void update(Object o, String[] params) {

  }

  @Override
  public int delete(Object o) {
    return 0;
  }
}
