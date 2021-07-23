package com.dalhousie.group14.Database.manager;

import com.dalhousie.group14.Database.utilities.DbConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertManagerID implements IInsertManagerID {

  public void insertManagerID(int employeeid, int managerid) {
    try {
      Connection connection = DbConnection.connectDB();
      String query = "UPDATE ResignRequest SET ManagerID=" + managerid + " where EmployeeID=" + employeeid + ";";
      Statement statement = connection.createStatement();
      statement.executeUpdate(query);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

}
