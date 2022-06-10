package com.spartaglobal.moviesapi.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FilmTests {

  @Test
  public void canICreateAFilm() {
    Film film = new Film();
    film.setTitle("The Godfather");
    Assertions.assertEquals("The Godfather", film.getTitle());
  }

}