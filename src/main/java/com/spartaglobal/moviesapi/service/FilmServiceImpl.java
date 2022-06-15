package com.spartaglobal.moviesapi.service;

import com.spartaglobal.moviesapi.dto.FilmDto;
import com.spartaglobal.moviesapi.exceptions.NoFilmsInDatabaseException;
import com.spartaglobal.moviesapi.model.Film;
import com.spartaglobal.moviesapi.repository.FilmRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class FilmServiceImpl implements FilmService {

  private final FilmRepository repo;

  public FilmServiceImpl(FilmRepository repo) {
    super();
    this.repo = repo;
  }

  @Override
  public List<Film> getAllFilms() throws NoFilmsInDatabaseException {
    try {
      List<FilmDto> filmEntities = repo.findAll();

      return filmEntities.stream()
          .map(filmDto -> new Film(filmDto.getTitle(), filmDto.getScore(), filmDto.getYear(),
              filmDto.getDuration(), filmDto.getRating(), filmDto.getBudget(), filmDto.getGenre(), filmDto.getGross(), filmDto.getDirector(),
              filmDto.getActor1(), filmDto.getActor2(), filmDto.getActor3(), filmDto.getLanguage(), filmDto.getCountry()))
          .collect(Collectors.toList());

    } catch (Exception e) {
      throw new NoFilmsInDatabaseException("No films in database");
    }
  }
}
