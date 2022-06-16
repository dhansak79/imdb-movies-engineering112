package com.spartaglobal.moviesapi.data;

import com.spartaglobal.moviesapi.filehandling.FileProcessor;
import com.spartaglobal.moviesapi.model.Film;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataLoader {

  private static final Logger logger = LogManager.getLogger(DataLoader.class);
  private final FileProcessor fileProcessor;
  private final FilmRepository filmRepository;

  @Autowired
  public DataLoader(FileProcessor fileProcessor, FilmRepository filmRepository) {
    this.fileProcessor = fileProcessor;
    this.filmRepository = filmRepository;
  }

  public void loadFileToDatabase(String filePath) {
    logger.info("Getting films from file: " + filePath + ".....");
    List<Film> films = fileProcessor.process(filePath);
    logger.info("Inserting films into the database.....");
    filmRepository.saveAll(films);
  }

}
