package com.spartaglobal.moviesapi.enums;

public enum AgeRating {

  // TODO: Are these valid ratings? TV-14, TV-MA, Approved, Unrated
  PG,
  G,
  PG13,
  R;


  public static AgeRating getRatingFromString(String string) {
    string = string.toUpperCase();

    return switch (string) {
      case "PG-13", "PG13" -> AgeRating.PG13;
      case "R" -> AgeRating.R;
      default -> null;
    };
  }
}
