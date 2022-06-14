package com.spartaglobal.moviesapi.controller;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

  private static Connection connection = null;

  public static Connection getConnection() throws IOException, SQLException {

    if (connection == null) {

      Properties databaseProperties = new Properties();
      databaseProperties.load(new FileReader(""));

      connection = DriverManager.getConnection
          (databaseProperties.getProperty("")
              , databaseProperties.getProperty(""),
              databaseProperties.getProperty(""));


    }
    return connection;
  }

  public static void closeConnection() throws SQLException {
    if (connection != null) {
      connection.close();
      connection = null;
    }
  }
}
