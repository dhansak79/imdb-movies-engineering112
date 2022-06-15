package com.spartaglobal.moviesapi.filehandling.validation.exceptions;

public class ValidateMoviesException {

  public static class InvalidLengthException extends ValidateException {
    public InvalidLengthException() {
      super("Incomplete length of data");
    }
  }

  public static class InvalidTitleException extends ValidateException {
    public InvalidTitleException() {
      super("Invalid movie title");
    }
  }


  public static class InvalidScoreException extends ValidateException {
    public InvalidScoreException() {
      super("Invalid score");
    }
  }

  public static class InvalidDurationException extends ValidateException {
    public InvalidDurationException() {
      super("Invalid duration. Duration must be a whole number.");
    }
  }

  public static class InvalidYearException extends ValidateException {
    public InvalidYearException() {
      super("Film year is invalid");
    }
  }

  public static class InvalidRatingException extends ValidateException {
    public InvalidRatingException() {
      super("Film rating is invalid");
    }

  }

  public static class InvalidBudgetException extends ValidateException {
    public InvalidBudgetException() {
      super("Budget must be a whole number");
    }
  }

  public static class InvalidGross extends ValidateException {
    public InvalidGross() {
      super("Gross is invalid. Gross must be a whole number.");
    }
  }

  public static class InvalidNameException extends ValidateException {
    public InvalidNameException() {
      super("Name is invalid.");
    }
  }

  public static class InvalidGenreException extends ValidateException {
    public InvalidGenreException() {
      super("Invalid movies genre");
    }
  }

  public static class InvalidCountryException extends ValidateException {
    public InvalidCountryException() {
      super("Invalid Country detected");
    }
  }

  public static class InvalidLanguageException extends ValidateException {
    public InvalidLanguageException() {
      super("Invalid Language Detected");
    }
  }
}
