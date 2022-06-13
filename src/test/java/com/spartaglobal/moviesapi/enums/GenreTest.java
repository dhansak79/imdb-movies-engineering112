package com.spartaglobal.moviesapi.enums;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class GenreTest {

  @ParameterizedTest
  @ValueSource(strings = {"invalid", "123", "wrong"})
  void invalidGenreTest(String input) {
    Assertions.assertNull(Genre.getGenreFromString(input));
  }

  @ParameterizedTest
  @ValueSource(strings = {"action", "ActIOn", "ACTION"})
  void validGenreTest(String input) {
    Assertions.assertEquals(Genre.ACTION, Genre.getGenreFromString(input));
  }
}
