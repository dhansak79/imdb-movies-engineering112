package com.spartaglobal.moviesapi;

import com.spartaglobal.moviesapi.controller.DataLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ImdbMoviesApiApplication {

  public static void main(String[] args) {
    String filepath = args[0];
    ConfigurableApplicationContext appContext = SpringApplication.run(
        ImdbMoviesApiApplication.class, args);
    DataLoader dataLoader = appContext.getBean(DataLoader.class);
    dataLoader.load(filepath);
  }
}
