package com.spartaglobal.moviesapi.enums;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
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
}
