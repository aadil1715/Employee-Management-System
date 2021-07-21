package com.dalhousie.group14.Database.utilities;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert_credentials implements insertCredentialsInterface {

  public void insert_credentials(String emailID, String password, String userType) {
    try {
      Connection connection = null;
      connection = dbConnection.connectDB();
      String query = "insert into LoginInfo values('" + emailID + "', '" + password + "', '" + userType + "');";
      Statement stmt = connection.createStatement();
      stmt.execute(query);
      connection.close();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }

  }

}