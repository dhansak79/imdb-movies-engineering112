package com.spartaglobal.moviesapi.writecsvfile;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteOutCSVFile {

  //Private constructor for utility class
  private WriteOutCSVFile() {
  }

  public static Boolean writeOutCSVFile(List<String[]> films, String writeOutFile) {
    try
        (BufferedWriter buffWrite = new BufferedWriter(new FileWriter(writeOutFile, false))) {
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

  public static Boolean corruptData(String invalidLine, String writeOutFile) {

    try
        (BufferedWriter buffWrite = new BufferedWriter(new FileWriter(writeOutFile, false))) {
      buffWrite.write(invalidLine);
      buffWrite.newLine();
      return true;

    } catch (IOException ioe) {
      System.out.println(ioe.getMessage());
      return false;
    }
  }
}






