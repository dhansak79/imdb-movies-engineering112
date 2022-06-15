package com.spartaglobal.moviesapi.service;

import com.spartaglobal.moviesapi.exceptions.NoFilmsInDatabaseException;
import com.spartaglobal.moviesapi.model.Film;
import java.util.List;

public interface FilmService {
  List<Film> getAllFilms() throws NoFilmsInDatabaseException;
}
