package com.spartaglobal.moviesapi.enums;

public enum Country {

  USA,
  NIGERIA,
  GERMANY,
  SOUTH_KOREA,
  CANADA,
  FRANCE,
  AUSTRALIA,
  THAILAND,
  INDIA,
  SPAIN,
  MEXICO,
  NORWAY,
  NEW_ZEALAND,
  BAHAMAS,
  CZECH_REPUBLIC,
  UK,
  DENMARK,
  NETHERLANDS,
  HONG_KONG,
  SWEDEN,
  SWITZERLAND,
  RUSSIA,
  SOUTH_AFRICA,
  BRAZIL,
  ICELAND,
  ARGENTINA,
  COLOMBIA,
  JAPAN,
  IRELAND,
  POLAND,
  ISRAEL,
  WEST_GERMANY,
  EGYPT,
  CHINA,
  ROMANIA,
  KYRGYZSTAN,
  ITALY,
  INDONESIA,
  PAKISTAN,
  SLOVENIA,
  UNITED_ARAB_EMIRATES,
  PHILIPPINES,
  IRAN,
  KENYA,
  BELGIUM,
  SOVIET_UNION;

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
