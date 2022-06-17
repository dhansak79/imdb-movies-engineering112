package com.spartaglobal.moviesapi.service;

import com.spartaglobal.moviesapi.data.FilmRepository;
import com.spartaglobal.moviesapi.model.Film;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
    List<Film> films = (List<Film>) repo.findAll();
    return Optional.of(films).orElse(getEmptyList());
  }

  @Override
  public Film getFilmById(Long id) {
    return repo.findById(id).get();
  }

  private List<Film> getEmptyList() {
    return new ArrayList<>();
  }
}
