package com.spartaglobal.moviesapi.enums;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LanguageTest {

  @ParameterizedTest
  @ValueSource(strings = {"invalid", "123", "wrong"})
  void invalidLanguageTest(String input) {
    Assertions.assertNull(Language.getLanguageFromString(input));
  }

  @ParameterizedTest
  @ValueSource(strings = {"english", "ENGLISH", "EnglISh"})
  void validLanguageTest(String input) {
    Assertions.assertEquals(Language.ENGLISH, Language.getLanguageFromString(input));
  }
}
