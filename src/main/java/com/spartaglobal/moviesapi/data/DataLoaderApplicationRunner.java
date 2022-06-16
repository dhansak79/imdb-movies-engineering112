package com.spartaglobal.moviesapi.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("!cucumber")
public class DataLoaderApplicationRunner implements ApplicationRunner {

  private DataLoader dataLoader;

  @Autowired
  public DataLoaderApplicationRunner(DataLoader dataLoader) {
    this.dataLoader = dataLoader;
  }

  @Override
  public void run(ApplicationArguments args) throws Exception {
    String filePath;
    if (args.getSourceArgs().length < 1) {
      filePath = "src/main/resources/imdb_data.csv";
    } else {
      filePath = args.getSourceArgs()[0];
    }
    dataLoader.loadFileToDatabase(filePath);
  }


}
