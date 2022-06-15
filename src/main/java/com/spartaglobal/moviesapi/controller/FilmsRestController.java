package com.spartaglobal.moviesapi.controller;

import com.spartaglobal.moviesapi.dto.Film;
import com.spartaglobal.moviesapi.exceptions.NoFilmsInDatabaseException;
import com.spartaglobal.moviesapi.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
