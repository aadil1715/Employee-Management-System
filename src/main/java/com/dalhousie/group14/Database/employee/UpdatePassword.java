package com.dalhousie.group14.Database.employee;

import com.dalhousie.group14.Database.utilities.DbConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdatePassword {

  /* This method Update the password in the database.
   */
  public void updatePassword(String userName, String password) {

    Statement statement;
    int resultSet;

    String query = "UPDATE `ems`.`LoginInfo` SET `Password` = '" + password + "' WHERE (`UserName` = '" + userName + "')";
    try {
      Connection connection = DbConnection.connectDB();
      statement = connection.createStatement();
      resultSet = statement.executeUpdate(query);
      if (resultSet > 0) {
        System.out.println("Update Successfully");
      } else {
        System.out.println("Password not update please check your employee id.");
      }

    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }

  }
}
