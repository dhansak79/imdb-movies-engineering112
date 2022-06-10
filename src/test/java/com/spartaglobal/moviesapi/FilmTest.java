package com.spartaglobal.moviesapi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.spartaglobal.moviesapi.model.Film;
import org.junit.jupiter.api.Test;

class FilmTest {

  @Test
  public void canICreateAFilm() {
    Film film = new Film();
    film.setTitle("The Godfather");
    assertEquals("The Godfather", film.getTitle());
  }


}