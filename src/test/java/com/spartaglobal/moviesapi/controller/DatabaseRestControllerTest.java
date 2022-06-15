package com.spartaglobal.moviesapi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spartaglobal.moviesapi.dto.FilmDto;
import com.spartaglobal.moviesapi.model.Film;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:schema.sql", "classpath:data.sql"},
    executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("dev")
class DatabaseRestControllerTest {

  @Autowired
  private MockMvc mvc;

  @Autowired
  private ObjectMapper mapper;

  @Disabled
  @Test
  public void testGetAllMovies() throws Exception {
    // Given
    FilmDto filmOne = new FilmDto("test", 1, 2009, 111,
        "PG", 1, "test", 1, "test", "test", "test",
        "test", "test", "test");
    FilmDto filmTwo = new FilmDto("test", 1, 2009, 111,
        "PG", 1, "test", 1, "test", "test", "test",
        "test", "test", "test");
    List<FilmDto> db = List.of(filmOne, filmTwo);

    String dbJSON = this.mapper.writeValueAsString(db);

    RequestBuilder req = get("/getFilms");

    ResultMatcher checkStatus = status().isOk();
    ResultMatcher checkBody = content().json(dbJSON);

    this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
  }
}