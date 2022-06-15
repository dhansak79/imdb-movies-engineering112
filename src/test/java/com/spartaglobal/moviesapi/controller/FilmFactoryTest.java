package com.spartaglobal.moviesapi.controller;

import static org.junit.jupiter.api.Assertions.*;

import com.spartaglobal.moviesapi.model.Film;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FilmFactoryTest {

  @Test
  public void checkFilmFactory(){
    String[] films = {"Titanic","7.9","1997","110","PG-13"
    ,"27000000","Romantic|Drama","850505879","James Cameron"
    ,"Leonardo DiCaprio", "Kate Winslet" ,"Billy Zane","English",
    "USA"};
    Film film = FilmFactory.createFilm(films);

    Assertions.assertEquals("Titanic",film.getTitle());
    Assertions.assertEquals(7.9,film.getScore());
    Assertions.assertEquals(1997,film.getYear());
    Assertions.assertEquals(110,film.getDuration());
    Assertions.assertEquals("PG-13",film.getRating());
    Assertions.assertEquals(27000000,film.getBudget());
    Assertions.assertEquals("Romantic|Drama",film.getGenre());
    Assertions.assertEquals(850505879,film.getGross());
    Assertions.assertEquals("James Cameron",film.getDirector());
    Assertions.assertEquals("Leonardo DiCaprio",film.getActor1());
    Assertions.assertEquals("Kate Winslet",film.getActor2());
    Assertions.assertEquals("Billy Zane",film.getActor3());
    Assertions.assertEquals("English",film.getLanguage());
    Assertions.assertEquals("USA",film.getCountry());









  }



}