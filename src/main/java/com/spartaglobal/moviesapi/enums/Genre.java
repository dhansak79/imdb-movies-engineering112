package com.spartaglobal.moviesapi.enums;

public enum Genre {

  ACTION,
  ADVENTURE,
  FANTASY,
  SCIFI,
  WESTERN;

  public static Genre getGenreFromString(String string) {
    string = string.toUpperCase();

    return switch (string) {
      case "ACTION" -> Genre.ACTION;
      case "ADVENTURE" -> Genre.ADVENTURE;
      case "FANTASY" -> Genre.FANTASY;
      case "SCI-FI" -> Genre.SCIFI;
      case "WESTERN" -> Genre.WESTERN;
      default -> null;
    };
  }
}
