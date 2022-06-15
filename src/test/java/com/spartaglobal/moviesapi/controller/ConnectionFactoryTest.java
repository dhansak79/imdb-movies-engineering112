package com.spartaglobal.moviesapi.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConnectionFactoryTest {

  @Test
  void testConnection() {
      Connection connection = ConnectionFactory.getConnection();
      Assertions.assertNotNull(connection);
  }
}



//    try {
//      Properties databaseProperties = new Properties();
//      databaseProperties.load(new FileReader(""));
//
//      DriverManager.getConnection
//          (databaseProperties.getProperty("")
//              , databaseProperties.getProperty(""),
//              databaseProperties.getProperty(""));
//    } catch (IOException | SQLException e) {
//      e.printStackTrace();
//
//      //assertTrue(java.sql.Connection.isValid(10000));
//
//    }


