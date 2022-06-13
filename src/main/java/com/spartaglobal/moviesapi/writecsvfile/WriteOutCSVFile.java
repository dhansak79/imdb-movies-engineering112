package com.spartaglobal.moviesapi.writecsvfile;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteOutCSVFile {

  public static Boolean writeOutCSVFile(List<String[]> films, String writeOutFile) {
      try
          (BufferedWriter buffWrite = new BufferedWriter(new FileWriter(writeOutFile, false))) {
        for(String [] film : films){
          String writeLine = String.join(",", film);
          buffWrite.write(writeLine);
          buffWrite.newLine();
        }
        return true;

      } catch (IOException io) {
        io.printStackTrace();
        return false;
      }

  }

  public static Boolean corruptData(String  films, String writeOutFile){

      String writeLine = String.join(",", films);
      try
          (BufferedWriter buffWrite = new BufferedWriter(new FileWriter(writeOutFile, false))) {
        buffWrite.write(writeLine);
        buffWrite.newLine();
        return true;

      } catch (IOException io) {
        io.printStackTrace();
        return false;
      }
  }
}






