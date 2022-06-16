package com.spartaglobal.moviesapi.unit.enums;

import static org.junit.jupiter.params.provider.Arguments.arguments;

import com.spartaglobal.moviesapi.model.enums.AgeRating;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class AgeRatingTest {

  @ParameterizedTest
  @ValueSource(strings = {"invalid", "123", "wrong"})
  void invalidAgeRatingTest(String input) {
    Assertions.assertNull(AgeRating.getRatingFromString(input));
  }

  @ParameterizedTest
  @ValueSource(strings = {"r", "R"})
  void validAgeRatingTest(String input) {
    Assertions.assertEquals(AgeRating.R, AgeRating.getRatingFromString(input));
  }

  @ParameterizedTest
  @MethodSource("testAllPossibleOutcomesData")
  public void testAllPossibleOutcomes(String input, AgeRating expectedAgeRating) {
    Assertions.assertEquals(expectedAgeRating, AgeRating.getRatingFromString(input));
  }

  private static Stream<Arguments> testAllPossibleOutcomesData() {
    return Stream.of(
        arguments("PG-13", AgeRating.PG_13),
        arguments("G", AgeRating.G),
        arguments("R", AgeRating.R),
        arguments("PG", AgeRating.PG),
        arguments("TV-14", AgeRating.TV_14),
        arguments("TV-PG", AgeRating.TV_PG),
        arguments("TV-MA", AgeRating.TV_MA),
        arguments("TV-G", AgeRating.TV_G),
        arguments("APPROVED", AgeRating.APPROVED),
        arguments("TV-Y", AgeRating.TV_Y),
        arguments("TV-Y7", AgeRating.TV_Y7),
        arguments("NC_17", AgeRating.NC_17),
        arguments("NOT_RATED", AgeRating.NOT_RATED)
    );
  }
}
