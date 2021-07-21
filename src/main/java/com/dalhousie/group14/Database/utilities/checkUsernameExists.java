package com.dalhousie.group14.Database.utilities;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class checkUsernameExists {
  static String name1;
  Insert_credentials object1= new Insert_credentials();
  public boolean checkUsernameExists(String name) {
    try {
      String query = "SELECT UserName FROM ems.LoginInfo WHERE EXISTS (SELECT UserName FROM ems.LoginInfo WHERE UserName ='" + name + "');";
      Statement statement=DbConnection.connectDB().createStatement();
      ResultSet rs = statement.executeQuery(query);
      System.out.println(rs.toString());
      return rs.next();
//      if(rs.next() == false) {
//        System.out.println("resultset is empty");
//      }
//      else {
//        while (rs.next()) {
//          name1 = rs.getString("UserName");
//        }
//      }
    } catch (SQLException throwables) {
      System.out.println(throwables);
    }
    return true;
  }

}
