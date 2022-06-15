package com.spartaglobal.moviesapi.controller;

import com.spartaglobal.moviesapi.dto.FilmDto;
import com.spartaglobal.moviesapi.exceptions.NoFilmsInDatabaseException;
import com.spartaglobal.moviesapi.model.Film;
import com.spartaglobal.moviesapi.service.FilmService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("")
public class DatabaseRestController {

  @Autowired
  private final FilmService service;

  public DatabaseRestController(FilmService service) {
    super();
    this.service = service;
  }

  @GetMapping("/getFilms")
  public ResponseEntity<List<Film>> getAllFilms() throws NoFilmsInDatabaseException {
    List<Film> films;
    films = service.getAllFilms();
    return ResponseEntity.ok(films);
  }
}
