package com.capps096apps.jsp_practice;

import java.sql.*;

public class UsersDatabaseConnector {
  Connection conn = null;

  public Connection getConnection() {

    // variables
    String dbDriver = "com.mysql.jdbc.Driver";
    // String dbDriver = "com.mysql.cj.jdbc.Driver";
    String dbURL = "jdbc:mysql://localhost:3306/";
    String dbName = "test";
    String dbUsername = "root";
    String dbPassword = "abc123";

    try {
      Class.forName(dbDriver);
      conn = DriverManager.getConnection(dbURL + dbName, dbUsername, dbPassword);
      System.out.println("Connection created");
      System.out.println("hashcode is: " + conn.hashCode());
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    } finally {
      System.out.println("here");
      System.out.println("hashcode is: " + conn.hashCode());
      System.out.println("hashcode now: " + conn.hashCode());
    }

    // return conn;
    return conn;
  }

  public void readFromDatabase() {

    try {
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT * FROM users");

      while (rs.next()) {
        System.out.println(rs.getString("name"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  // addd a new user to the database with params fisrtName, lastName, email, password
  public void addUserToDatabase(String firstName, String lastName, String email, String password) {
    try {
      PreparedStatement pstmt = conn.prepareStatement("INSERT INTO users (first_name, last_name, email, password) VALUES (?, ?, ?, ?)");
      pstmt.setString(1, firstName);
      pstmt.setString(2, lastName);
      pstmt.setString(3, email);
      pstmt.setString(4, password);
      pstmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

}
