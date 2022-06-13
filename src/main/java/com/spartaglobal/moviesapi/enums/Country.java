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
      case "SOUTH KOREA" -> Country.SOUTH_KOREA;
      case "CANADA" -> Country.CANADA;
      case "FRANCE" -> Country.FRANCE;
      case "AUSTRALIA" -> Country.AUSTRALIA;
      case "THAILAND" -> Country.THAILAND;
      case "INDIA" -> Country.INDIA;
      case "SPAIN" -> Country.SPAIN;
      case "MEXICO" -> Country.MEXICO;
      case "NORWAY" -> Country.NORWAY;
      case "NEW ZEALAND" -> Country.NEW_ZEALAND;
      case "BAHAMAS" -> Country.BAHAMAS;
      case "CZECH REPUBLIC" -> Country.CZECH_REPUBLIC;
      case "UK" -> Country.UK;
      case "DENMARK" -> Country.DENMARK;
      case "NETHERLANDS" -> Country.NETHERLANDS;
      case "HONG KONG" -> Country.HONG_KONG;
      case "SWEDEN" -> Country.SWEDEN;
      case "SWITZERLAND" -> Country.SWITZERLAND;
      case "RUSSIA" -> Country.RUSSIA;
      case "SOUTH AFRICA" -> Country.SOUTH_AFRICA;
      case "BRAZIL" -> Country.BRAZIL;
      case "ICELAND" -> Country.ICELAND;
      case "ARGENTINA" -> Country.ARGENTINA;
      case "COLOMBIA" -> Country.COLOMBIA;
      case "JAPAN" -> Country.JAPAN;
      case "IRELAND" -> Country.IRELAND;
      case "POLAND" -> Country.POLAND;
      case "ISRAEL" -> Country.ISRAEL;
      case "WEST GERMANY" -> Country.WEST_GERMANY;
      case "EGYPT" -> Country.EGYPT;
      case "CHINA" -> Country.CHINA;
      case "ROMANIA" -> Country.ROMANIA;
      case "KYRGYZSTAN" -> Country.KYRGYZSTAN;
      case "ITALY" -> Country.ITALY;
      case "INDONESIA" -> Country.INDONESIA;
      case "PAKISTAN" -> Country.PAKISTAN;
      case "SLOVENIA" -> Country.SLOVENIA;
      case "UNITED ARAB EMIRATES" -> Country.UNITED_ARAB_EMIRATES;
      case "PHILIPPINES" -> Country.PHILIPPINES;
      case "IRAN" -> Country.IRAN;
      case "KENYA" -> Country.KENYA;
      case "BELGIUM" -> Country.BELGIUM;
      case "SOVIET UNION" -> Country.SOVIET_UNION;
      default -> null;
    };
  }
}
