package com.spartaglobal.moviesapi.service.exceptions;

import java.util.function.Supplier;

public class NoFilmsInDatabaseException extends Exception implements
    Supplier<NoFilmsInDatabaseException> {

  public NoFilmsInDatabaseException(String message) {
    super(message);
  }
  public NoFilmsInDatabaseException() {
    super();
  }

  @Override
  public NoFilmsInDatabaseException get() {
    return new NoFilmsInDatabaseException();
  }

}


