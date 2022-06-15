package com.spartaglobal.moviesapi;

import com.spartaglobal.moviesapi.dto.Film;
import com.spartaglobal.moviesapi.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ImdbMoviesApiApplication {

  static FilmRepository filmRepository;
  public static void main(String[] args) {
    String filepath = args[0];
    SpringApplication.run(ImdbMoviesApiApplication.class, args);
    FileProcessor fileProcessor = new FileProcessor(filmRepository);
    fileProcessor.process(filepath);
  }

  @Bean
  public CommandLineRunner run(FilmRepository filmRepo) throws Exception {
    return (String[] args) -> {
      this.filmRepository = filmRepo;
    };
  }

}
