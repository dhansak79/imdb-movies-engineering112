package com.spartaglobal.moviesapi.service;

import com.spartaglobal.moviesapi.model.Film;
import com.spartaglobal.moviesapi.service.exceptions.NoFilmsInDatabaseException;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public interface FilmService {
  List<Film> getAllFilms() throws NoFilmsInDatabaseException;
}
