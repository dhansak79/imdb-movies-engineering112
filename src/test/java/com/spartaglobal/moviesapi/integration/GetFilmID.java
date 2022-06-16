package com.spartaglobal.moviesapi.integration;

import com.spartaglobal.moviesapi.model.Film;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class GetFilmID {

  @Test
  public void getFilmById() {
    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<Film> responseEntity =
        restTemplate.getForEntity("http://localhost:8080/getFilm/1", Film.class);
    Film film = responseEntity.getBody();
    Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    Assertions.assertEquals("Avatar", film.getTitle());
  }
}
