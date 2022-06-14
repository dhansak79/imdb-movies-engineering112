package com.spartaglobal.moviesapi.filehandling;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CsvWriter {

  private static final Logger logger = LogManager.getLogger("CsvWriter");

  //Private constructor for utility class
  private CsvWriter() {
  }

  public static Boolean writeListOfStringArraysToCSV(List<String[]> films, String writeOutFile) {

    try (BufferedWriter buffWrite = new BufferedWriter(new FileWriter(writeOutFile, false))) {
      for (String[] film : films) {
        String writeLine = String.join(",", film);
        buffWrite.write(writeLine);
        buffWrite.newLine();
      }
      return true;

    } catch (IOException ioe) {
      logger.error(ioe.getMessage());
      return false;
    }

  }

}
