package com.spartaglobal.moviesapi.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class MyStepdefs {

  @Given("all details are correct")
  public void all_details_are_correct() {
    System.out.println("*Inputs correct details*");
  }

  @When("the user presses the login button")
  public void the_user_presses_the_login_button() {
    System.out.println("*Clicks login*");
  }

  @Then("their details are accepted and log in")
  public void their_details_are_accepted_and_log_in() {
    Assertions.assertTrue(true);
  }

  @Given("I want to eat Spaghetti")
  public void iWantToEatSpaghetti() {
    System.out.println("*I'm hungry for spaghetti*");
  }

  @When("I find Spaghetti")
  public void iFindSpaghetti() {
    System.out.println("*Finds Spaghetti*");
  }

  @Then("I eat it")
  public void iEatIt() {
    Assertions.assertTrue(true);
  }
}
