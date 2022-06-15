package com.spartaglobal.moviesapi.controller;

import com.spartaglobal.moviesapi.model.Film;
import com.spartaglobal.moviesapi.repository.FilmRepository;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

  private static final Logger logger = LogManager.getLogger(DataLoader.class);
  private final FileProcessor fileProcessor;
  private final FilmRepository filmRepository;

  @Autowired
  public DataLoader(FileProcessor fileProcessor, FilmRepository filmRepository) {
    this.fileProcessor = fileProcessor;
    this.filmRepository = filmRepository;
  }

  @Override
  public void run(ApplicationArguments args) throws Exception {
    String filePath;
    if (args.getSourceArgs().length < 1) {
      filePath = "src/main/resources/imdb_data.csv";
    } else {
      filePath = args.getSourceArgs()[0];
    }
    logger.info("Getting films from file: " + args + ".....");
    List<Film> films = fileProcessor.process(filePath);
    logger.info("Inserting films into the database.....");
    filmRepository.saveAll(films);
  }
}
