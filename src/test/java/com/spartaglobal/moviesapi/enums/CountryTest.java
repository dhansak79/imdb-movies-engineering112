package com.spartaglobal.moviesapi.enums;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CountryTest {

  @ParameterizedTest
  @ValueSource(strings = {"invalid", "123", "wrong"})
  void invalidCountryTest(String input) {
    Assertions.assertNull(Country.getCountryFromString(input));
  }

  @ParameterizedTest
  @ValueSource(strings = {"usa", "USA", "UsA"})
  void validCountryTest(String input) {
    Assertions.assertEquals(Country.USA, Country.getCountryFromString(input));
  }
}
