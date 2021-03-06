package com.spartaglobal.moviesapi.model.enums;

public enum AgeRating {

  // TODO: Are these valid ratings? TV-14, TV-MA, Approved, Unrated
  PG,
  G,
  PG_13,
  R,
  TV_14,
  TV_PG,
  TV_MA,
  TV_G,
  APPROVED,
  TV_Y,
  TV_Y7,
  NC_17,
  NOT_RATED,
  UNRATED,
  X,
  GP,
  PASSED,
  M;


  public static AgeRating getRatingFromString(String string) {
    string = string.toUpperCase();

    return switch (string) {
      case "PG-13", "PG13" -> AgeRating.PG_13;
      case "G" -> AgeRating.G;
      case "R" -> AgeRating.R;
      case "PG" -> AgeRating.PG;
      case "TV-14" -> AgeRating.TV_14;
      case "TV-PG" -> AgeRating.TV_PG;
      case "TV-MA" -> AgeRating.TV_MA;
      case "TV-G" -> AgeRating.TV_G;
      case "APPROVED" -> AgeRating.APPROVED;
      case "TV-Y" -> AgeRating.TV_Y;
      case "TV-Y7" -> AgeRating.TV_Y7;
      case "NC-17" -> AgeRating.NC_17;
      case "NOT-RATED" -> AgeRating.NOT_RATED;
      case "UNRATED" -> AgeRating.UNRATED;
      case "X" -> AgeRating.X;
      case "GP" -> AgeRating.GP;
      case "PASSED" -> AgeRating.PASSED;
      case "M" -> AgeRating.M;
      default -> null;
    };
  }
}
