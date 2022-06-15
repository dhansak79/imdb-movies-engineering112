package com.spartaglobal.moviesapi.service;

import com.spartaglobal.moviesapi.model.Film;
import com.spartaglobal.moviesapi.repository.FilmRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class FilmServiceImpl implements FilmService {

  private final FilmRepository repo;

  public FilmServiceImpl(FilmRepository repo) {
    super();
    this.repo = repo;
  }

  @Override
  public List<Film> getAllFilms() {
    return (List<Film>) repo.findAll();
  }
}
