package com.spartaglobal.moviesapi.integration;

import com.spartaglobal.moviesapi.data.FilmRepository;
import com.spartaglobal.moviesapi.model.Film;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class getFilmTitleTest {

  @Autowired
  FilmRepository filmRepository;

  @Test
  @Disabled
  public void getFilmsBeginningWith() {

    List<Film> result = filmRepository.searchTitleUsingBeginningLetter("z");

    System.out.println(Arrays.deepToString(result.toArray()));
    Assertions.assertEquals(10, result.size());
  }


}



