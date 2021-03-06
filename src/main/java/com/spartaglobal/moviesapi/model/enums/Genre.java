package com.spartaglobal.moviesapi.model.enums;

public enum Genre {

  ACTION,
  ADVENTURE,
  FANTASY,
  SCI_FI,
  WESTERN,
  ROMANCE,
  THRILLER,
  DOCUMENTARY,
  ANIMATION,
  FAMILY,
  MUSICAL,
  COMEDY,
  DRAMA,
  HORROR,
  SPORT,
  CRIME,
  MYSTERY,
  HISTORY,
  WAR,
  BIOGRAPHY,
  MUSIC,
  GAME_SHOW,
  REALITY_TV,
  NEWS,
  SHORT,
  FILM_NOIR;

  public static Genre getGenreFromString(String string) {
    string = string.toUpperCase();

    return switch (string) {
      case "ACTION" -> Genre.ACTION;
      case "ADVENTURE" -> Genre.ADVENTURE;
      case "FANTASY" -> Genre.FANTASY;
      case "SCI-FI" -> Genre.SCI_FI;
      case "WESTERN" -> Genre.WESTERN;
      case "ROMANCE" -> Genre.ROMANCE;
      case "THRILLER" -> Genre.THRILLER;
      case "DOCUMENTARY" -> Genre.DOCUMENTARY;
      case "ANIMATION" -> Genre.ANIMATION;
      case "FAMILY" -> Genre.FAMILY;
      case "MUSICAL" -> Genre.MUSICAL;
      case "COMEDY" -> Genre.COMEDY;
      case "DRAMA" -> Genre.DRAMA;
      case "HORROR" -> Genre.HORROR;
      case "SPORT" -> Genre.SPORT;
      case "CRIME" -> Genre.CRIME;
      case "MYSTERY" -> Genre.MYSTERY;
      case "HISTORY" -> Genre.HISTORY;
      case "WAR" -> Genre.WAR;
      case "BIOGRAPHY" -> Genre.BIOGRAPHY;
      case "MUSIC" -> Genre.MUSIC;
      case "GAME-SHOW" -> Genre.GAME_SHOW;
      case "REALITY-TV" -> Genre.REALITY_TV;
      case "NEWS" -> Genre.NEWS;
      case "SHORT" -> Genre.SHORT;
      case "FILM-NOIR" -> Genre.FILM_NOIR;

      default -> null;
    };
  }
}
