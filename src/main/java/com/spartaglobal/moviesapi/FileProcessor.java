package com.spartaglobal.moviesapi;

import com.spartaglobal.moviesapi.controller.DataValidation;
import com.spartaglobal.moviesapi.csvwriter.CSVWriter;
import com.spartaglobal.moviesapi.readin.CsvReader;
import java.util.ArrayList;
import java.util.List;

public class FileProcessor {

  public void process(String filePath) {
    List<String[]> rawRecords = CsvReader.readFile(filePath);
    List<String[]> validRecords = new ArrayList<>();
    List<String[]> invalidRecords = new ArrayList<>();

    for (String[] rawRecord : rawRecords) {
      boolean isValid = DataValidation.validateData(rawRecord);

      if (isValid) {
        validRecords.add(rawRecord);
      } else {
        invalidRecords.add(rawRecord);
      }
    }

    CSVWriter.writeListOfStringArraysToCSV(validRecords, "cleanRecords.csv");
    CSVWriter.writeListOfStringArraysToCSV(invalidRecords, "invalidRecords.csv");
  }
}
