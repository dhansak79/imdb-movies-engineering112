package com.spartaglobal.moviesapi.enums;

public enum Country {

  USA,
  NIGERIA,
  GERMANY,
  SOUTH_KOREA;

  public static Country getCountryFromString(String string) {
    string = string.toUpperCase();

    return switch (string) {
      case "USA" -> Country.USA;
      case "NIGERIA" -> Country.NIGERIA;
      case "GERMANY" -> Country.GERMANY;
      case "SOUTH_KOREA" -> Country.SOUTH_KOREA;
      default -> null;
    };
  }
}
