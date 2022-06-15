package com.spartaglobal.moviesapi.enums;

import static org.junit.jupiter.params.provider.Arguments.arguments;

import com.spartaglobal.moviesapi.model.enums.Genre;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
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

  @ParameterizedTest
  @MethodSource("testAllPossibleOutcomesData")
  public void testAllPossibleOutcomes(String input, Genre expectedGenre) {
    Assertions.assertEquals(expectedGenre, Genre.getGenreFromString(input));
  }

  private static Stream<Arguments> testAllPossibleOutcomesData() {
    return Stream.of(
        arguments("ACTION", Genre.ACTION),
        arguments("ADVENTURE", Genre.ADVENTURE),
        arguments("FANTASY", Genre.FANTASY),
        arguments("SCI-FI", Genre.SCI_FI),
        arguments("WESTERN", Genre.WESTERN),
        arguments("ROMANCE", Genre.ROMANCE),
        arguments("THRILLER", Genre.THRILLER),
        arguments("DOCUMENTARY", Genre.DOCUMENTARY),
        arguments("ANIMATION", Genre.ANIMATION),
        arguments("FAMILY", Genre.FAMILY),
        arguments("MUSICAL", Genre.MUSICAL),
        arguments("COMEDY", Genre.COMEDY),
        arguments("DRAMA", Genre.DRAMA),
        arguments("HORROR", Genre.HORROR),
        arguments("SPORT", Genre.SPORT),
        arguments("CRIME", Genre.CRIME),
        arguments("MYSTERY", Genre.MYSTERY),
        arguments("HISTORY", Genre.HISTORY),
        arguments("WAR", Genre.WAR),
        arguments("BIOGRAPHY", Genre.BIOGRAPHY)
    );
  }
}
