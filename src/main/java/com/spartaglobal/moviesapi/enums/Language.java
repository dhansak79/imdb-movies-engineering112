package com.spartaglobal.moviesapi.enums;

public enum Language {
  ENGLISH,
  JAPANESE,
  MANDARIN,
  CANTONESE,
  SPANISH,
  GERMAN,
  THAI,
  POLISH,
  FRENCH,
  RUSSIAN,
  SWEDISH,
  KOREAN,
  ITALIAN,
  PORTUGUESE,
  HINDI,
  ICELANDIC,
  ABORIGINAL,
  ARABIC,
  NORWEGIAN;


  public static Language getLanguageFromString(String string) {
    string = string.toUpperCase();

    return switch (string) {
      case "ENGLISH" -> Language.ENGLISH;
      case "JAPANESE" -> Language.JAPANESE;
      case "MANDARIN" -> Language.MANDARIN;
      case "CANTONESE" -> Language.CANTONESE;
      case "SPANISH" -> Language.SPANISH;
      case "GERMAN" -> Language.GERMAN;
      case "THAI" -> Language.THAI;
      case "POLISH" -> Language.POLISH;
      case "FRENCH" -> Language.FRENCH;
      case "RUSSIAN" -> Language.RUSSIAN;
      case "SWEDISH" -> Language.SWEDISH;
      case "KOREAN" -> Language.KOREAN;
      case "ITALIAN" -> Language.ITALIAN;
      case "PORTUGUESE" -> Language.PORTUGUESE;
      case "HINDI" -> Language.HINDI;
      case "ICELANDIC" -> Language.ICELANDIC;
      case "ABORIGINAL" -> Language.ABORIGINAL;
      case "ARABIC" -> Language.ARABIC;
      case "NORWEGIAN" -> Language.NORWEGIAN;
      default -> null;
    };
  }
}
