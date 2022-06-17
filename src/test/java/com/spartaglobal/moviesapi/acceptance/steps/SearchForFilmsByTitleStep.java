package com.spartaglobal.moviesapi.acceptance.steps;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import com.spartaglobal.moviesapi.model.Film;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.Arrays;
import java.util.Locale;
import org.junit.jupiter.api.Assertions;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class SearchForFilmsByTitleStep {

  private ResponseEntity<Film[]> filmResponseEntity;

  @When("We search for {string}")
  public void weSearchFor(String input) {
    RestTemplate restTemplate = new RestTemplate();
    filmResponseEntity = restTemplate.getForEntity("http://localhost:8080/getFilms/" + input,  Film[].class);
  }

  @Then("films starting with {string} are returned")
  public void filmsStartingWithAreReturned(String  character) {
    for(Film film : Arrays.stream(filmResponseEntity.getBody()).toList() ){
      Assertions.assertEquals(character.charAt(0), film.getTitle().charAt(0));
    }
  }

  @Then("films containing {string} are returned")
  public void filmsContainingAreReturned(String stringInput) {
    for(Film film : Arrays.stream(filmResponseEntity.getBody()).toList() ){
      assertThat(film.getTitle()).containsIgnoringCase(stringInput);
    }
  }
}
