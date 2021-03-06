package com.spartaglobal.moviesapi.filehandling.validation.exceptions;

public abstract class ValidateException extends Exception {

  private final String message;

  public ValidateException(String msg) {
    this.message = msg;
  }

  public String getMessage() {
    return message;
  }
}
