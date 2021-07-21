package com.dalhousie.group14.Database.manager;

import com.dalhousie.group14.Database.utilities.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class insert_Manager_ID {

  Connection connection = DbConnection.connectDB();
  static int id = 0;

  public void insertManagerID(int employeeid, int managerid) {
    try {
      String query = "UPDATE ResignRequest SET ManagerID=" + managerid + " where EmployeeID=" + employeeid + ";";
      Statement statement = connection.createStatement();
      statement.executeUpdate(query);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

}
