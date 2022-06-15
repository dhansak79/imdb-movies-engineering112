package com.spartaglobal.moviesapi.exceptions;

public class NoFilmsInDatabaseException extends Exception{

  public NoFilmsInDatabaseException(String message) {
    super(message);
  }
}
