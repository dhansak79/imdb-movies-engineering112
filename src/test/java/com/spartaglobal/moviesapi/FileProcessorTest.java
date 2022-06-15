package com.spartaglobal.moviesapi;

import static org.junit.jupiter.api.Assertions.*;

import com.spartaglobal.moviesapi.controller.ConnectionFactory;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FileProcessorTest {

  @Test
  void processTest() throws SQLException, IOException {
    FileProcessor fileProcessor = new FileProcessor();
    String filePath = "cleanRecords.csv";

    fileProcessor.loadDb(filePath);

    Connection con = ConnectionFactory.getConnection();
    PreparedStatement preparedStatement = con.prepareStatement(
        "SELECT COUNT(*) AS total FROM films;");

    ResultSet resultSet = preparedStatement.executeQuery();

    resultSet.next();
    int numberOfRecords = resultSet.getInt(1);

    Assertions.assertEquals(3, numberOfRecords);
  }
}