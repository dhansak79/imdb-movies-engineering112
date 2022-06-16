package com.spartaglobal.moviesapi.acceptance.steps;

import com.spartaglobal.moviesapi.data.FilmRepository;
import com.spartaglobal.moviesapi.model.Film;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@Disabled
public class GetAllFilmsSteps {

  @Autowired
  private FilmRepository filmRepository;

  private ResponseEntity<Film[]> filmResponseEntity;

  @Given("there are {int} films")
  public void thereAreFilms(int desiredNumberOfFilms) {
    filmRepository.deleteAll();
    List<Film> filmsToLoad = new ArrayList<>();
    for (int i = 0; i < desiredNumberOfFilms; i++) {
      filmsToLoad.add(new Film("The Godfather", 7.9, 2009, 178, "PG-13", 237000000,
          "Action|Adventure|Fantasy|Sci-Fi", 760505847, "James Cameron",
          "CCH Pounder", "Joel David Moore", "Wes Studi", "English", "USA"
      ));
    }
    filmRepository.saveAll(filmsToLoad);
  }


  @When("I get all films")
  public void iGetAllFilms() {
    RestTemplate restTemplate = new RestTemplate();
    filmResponseEntity = restTemplate.getForEntity("http://localhost:8080/getFilms", Film[].class);
  }

  @Given("there are no films")
  public void thereAreNoFilms() {

  }

  @Then("I get no films")
  public void iGetNoFilms() {
    allFilmsAreReturned(0);
  }

  @Then("all {int} films are returned")
  public void allFilmsAreReturned(int expectedNumberOfFilms) {
    Assertions.assertEquals(expectedNumberOfFilms, filmResponseEntity.getBody().length);
  }
}
