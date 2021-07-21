package com.dalhousie.group14.Database.manager;

import com.dalhousie.group14.Database.utilities.DbConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class rejected_status {

  public void reject_status(int id) {
    Connection connection = DbConnection.connectDB();
    String query = "UPDATE ResignRequest SET ApprovedStatus = 'rejected' WHERE EmployeeID =" + id + ";";
    Statement stmt = null;
    try {
      stmt = connection.createStatement();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    try {
      stmt.executeUpdate(query);
      connection.close();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }

  }

}




