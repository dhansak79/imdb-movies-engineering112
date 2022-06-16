package com.spartaglobal.moviesapi.unit.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spartaglobal.moviesapi.model.Film;
import com.spartaglobal.moviesapi.data.FilmRepository;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@DataJpaTest
class FilmsRepositoryControllerTest {

  @Autowired
  private FilmRepository repo;

  @Autowired
  private MockMvc mvc;

  @Autowired
  private ObjectMapper mapper;

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

  @Test
  public void getMovieById() throws Exception {
    Long id = 1l;

    Film filmOne = new Film("test", 1, 2009, 111,
        "PG", 1, "test", 1, "test", "test", "test",
        "test", "test", "test");

    String found = this.mapper.writeValueAsString(filmOne);

    RequestBuilder req = get("/getFilm/" + id);
    ResultMatcher checkStatus = status().isOk();
    ResultMatcher checkBody = content().json(found);

    this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
  }
}