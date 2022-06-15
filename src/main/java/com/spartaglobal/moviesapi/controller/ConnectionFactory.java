package com.spartaglobal.moviesapi.controller;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

  private static Connection connection = null;

  public static Connection getConnection() {
    try {
      if (connection == null || connection.isClosed()) {

        Properties databaseProperties = new Properties();
        databaseProperties.load(new FileReader("src/main/resources/mysql.properties"));

        connection = DriverManager.getConnection
            (databaseProperties.getProperty("dburl")
                , databaseProperties.getProperty("dbuserid"),
                databaseProperties.getProperty("dbpassword"));
      }
    }catch (SQLException | IOException e){
      e.printStackTrace();
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
