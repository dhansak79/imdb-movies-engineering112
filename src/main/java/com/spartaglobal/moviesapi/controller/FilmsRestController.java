package com.spartaglobal.moviesapi.controller;

import com.spartaglobal.moviesapi.model.Film;
import com.spartaglobal.moviesapi.service.exceptions.IdNotFoundException;
import com.spartaglobal.moviesapi.service.exceptions.NoFilmsInDatabaseException;
import com.spartaglobal.moviesapi.service.FilmService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("")
public class FilmsRestController {

  @Autowired
  private final FilmService service;

  public FilmsRestController(FilmService service) {
    super();
    this.service = service;
  }

  @GetMapping("/getFilms")
  public ResponseEntity<Iterable<Film>> getAllFilms() throws NoFilmsInDatabaseException {
    Iterable<Film> films;
    films = service.getAllFilms();
    return ResponseEntity.ok(films);
  }

  @GetMapping("/getFilm/{id}")
  public ResponseEntity<Film> getFilmById(@PathVariable("id") Long id) throws IdNotFoundException {
    Film film = null;
    film = service.getFilmById(id);
    return ResponseEntity.ok(film);
  }

  @GetMapping("/getFilms/{title}")
  public ResponseEntity<Iterable<Film>> getAllFilmsByTitle(@PathVariable String title) throws NoFilmsInDatabaseException {
    Iterable<Film> films;
    List<Film> matchedFilms = new ArrayList<>();
    films = service.getAllFilms();

    for (Film film: films) {
      String lowerCaseTitle = film.getTitle().toLowerCase();
      if (Integer.valueOf(1).equals(title.length())){
        if(lowerCaseTitle.startsWith(title.toLowerCase())) {
          matchedFilms.add(film);
        }
      } else {
        if (lowerCaseTitle.contains(title.toLowerCase())){
          matchedFilms.add(film);
        }
      }
    }
    return ResponseEntity.ok(matchedFilms);
  }

}
