package com.spartaglobal.moviesapi.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.spartaglobal.moviesapi.model.Film;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FilmTest {

  @Test
  public void canICreateAFilm() {
    Film film = new Film("The Godfather", 7.9, 2009, 178, "PG-13", 237000000,
        "Action|Adventure|Fantasy|Sci-Fi", 760505847, "James Cameron",
        "CCH Pounder", "Joel David Moore", "Wes Studi", "English", "USA"
    );
    assertEquals("The Godfather", film.getTitle());
  }

  @Test
  public void areTheseFilmsTheSame() {
    Film film = new Film("The Godfather", 7.9, 2009, 178, "PG-13", 237000000,
        "Action|Adventure|Fantasy|Sci-Fi", 760505847, "James Cameron",
        "CCH Pounder", "Joel David Moore", "Wes Studi", "English", "USA"
    );

    Film film2 = new Film("The Godfather", 7.9, 2009, 178, "PG-13", 237000000,
        "Action|Adventure|Fantasy|Sci-Fi", 760505847, "James Cameron",
        "CCH Pounder", "Joel David Moore", "Wes Studi", "English", "USA"
    );

    Assertions.assertTrue(film.equals(film2));
  }

}