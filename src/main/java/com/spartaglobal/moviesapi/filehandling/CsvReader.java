package com.spartaglobal.moviesapi.filehandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CsvReader {

  private static final Logger logger = LogManager.getLogger("log");

  public static List<String[]> readCSVFile(String fileName, boolean hasHeaders) {
    List<String[]> list = new ArrayList<>();

    logger.info("Reading file " + fileName);
    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
      if (hasHeaders) { String store = bufferedReader.readLine(); }
      String line;
      while ((line = bufferedReader.readLine()) != null) {
        list.add(line.split(","));
      }
    } catch (IOException e) {
      logger.error(e.getMessage());
    }
    return list;
  }
}



