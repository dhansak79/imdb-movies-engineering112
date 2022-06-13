package com.spartaglobal.moviesapi.csvwriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVWriter {

  //Private constructor for utility class
  private CSVWriter() {
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
      System.out.println(ioe.getMessage());
      return false;
    }

  }

}
