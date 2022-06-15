package com.spartaglobal.moviesapi.service;

import com.spartaglobal.moviesapi.exceptions.NoFilmsInDatabaseException;
import com.spartaglobal.moviesapi.model.Film;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public interface FilmService {
  List<Film> getAllFilms() throws NoFilmsInDatabaseException;
}
