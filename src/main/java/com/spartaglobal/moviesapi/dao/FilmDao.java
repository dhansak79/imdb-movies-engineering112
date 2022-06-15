package com.spartaglobal.moviesapi.dao;

import com.spartaglobal.moviesapi.model.Film;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface FilmDao<T> {

  Optional<T> get(int id);

  List<Film> getAll() throws SQLException;

  int save(T t);

  int save(Film film);

  void update(T t, String[] params);

  int delete(T t);
}
