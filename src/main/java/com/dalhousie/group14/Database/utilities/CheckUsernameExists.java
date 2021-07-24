package com.dalhousie.group14.Database.utilities;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CheckUsernameExists implements ICheckUsernameExists {

  public boolean checkUsernameExists(String name) {
    try {
      Connection connection = DbConnection.connectDB();
      String query = "SELECT UserName FROM ems.LoginInfo WHERE EXISTS (SELECT UserName FROM ems.LoginInfo WHERE UserName ='" + name + "');";
      Statement statement = connection.createStatement();
      ResultSet rs = statement.executeQuery(query);
      if (rs != null) {
        return true;
      }
    } catch (SQLException throwables) {
      System.out.println(throwables);
    }
    return false;
  }

}
