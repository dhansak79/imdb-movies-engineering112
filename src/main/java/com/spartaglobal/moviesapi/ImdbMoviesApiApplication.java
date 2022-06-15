package com.spartaglobal.moviesapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
public class ImdbMoviesApiApplication {

  public static void main(String[] args) {
    String filepath = args[0];
    SpringApplication.run(ImdbMoviesApiApplication.class, args);
    FileProcessor fileProcessor = new FileProcessor();
    fileProcessor.process(filepath);
  }

}
