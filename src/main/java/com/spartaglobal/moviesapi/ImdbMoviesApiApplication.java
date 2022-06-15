package com.spartaglobal.moviesapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
public class ImdbMoviesApiApplication {

  public static void main(String[] args) {
    SpringApplication.run(ImdbMoviesApiApplication.class, args);
  }

}
