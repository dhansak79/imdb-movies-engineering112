package com.spartaglobal.moviesapi.controller;

import com.spartaglobal.moviesapi.model.Film;
import com.spartaglobal.moviesapi.service.exceptions.NoFilmsInDatabaseException;
import com.spartaglobal.moviesapi.service.FilmService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("")
public class FilmsRestController {

  @Autowired
  private final FilmService service;

  public FilmsRestController(FilmService service){
    super();
    this.service = service;
  }

  @GetMapping("/getFilms")
  public ResponseEntity<Iterable<Film>> getAllFilms() throws NoFilmsInDatabaseException {
    Iterable<Film> films;
    films = service.getAllFilms();
    return ResponseEntity.ok(films);
  }


  @GetMapping("/getFilms/search")
  public ResponseEntity<Iterable<Film>> getAllFilmsByTitle(@RequestParam String title) throws NoFilmsInDatabaseException {
    Iterable<Film> films;
    List<Film> matchedFilms = new ArrayList<>();
    films = service.getAllFilms();
    for (Film film: films) {
      String lowerCaseTitle = film.getTitle().toLowerCase();
      if(lowerCaseTitle.startsWith(title)) {
        matchedFilms.add(film);
      } else if (title.length() > 1
          && lowerCaseTitle.contains (title)) {
        matchedFilms.add(film);
      }
    }
    return ResponseEntity.ok(matchedFilms);
  }
}
