package com.spartaglobal.moviesapi.service.exceptions;

public class NoFilmsInDatabaseException extends Exception{

  public NoFilmsInDatabaseException(String message) {
    super(message);
  }
}
