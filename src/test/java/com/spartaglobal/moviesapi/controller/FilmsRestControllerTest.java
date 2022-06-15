package com.spartaglobal.moviesapi.controller;

import com.spartaglobal.moviesapi.dto.Film;
import com.spartaglobal.moviesapi.repository.FilmRepository;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("dev")
class FilmsRestControllerTest {

  @Autowired
  private FilmRepository repo;

  @Test
  public void testGetAllMovies() throws Exception {
    // Given
    Film filmOne = new Film("test", 1, 2009, 111,
        "PG", 1, "test", 1, "test", "test", "test",
        "test", "test", "test");
    Film filmTwo = new Film("test", 1, 2009, 111,
        "PG", 1, "test", 1, "test", "test", "test",
        "test", "test", "test");

    repo.save(filmOne);

    List<Film> film = (List<Film>) repo.findAll();

    Assertions.assertEquals(1, film.size());
  }
}