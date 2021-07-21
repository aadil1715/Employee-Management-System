package com.dalhousie.group14.Database.manager;

import com.dalhousie.group14.Database.utilities.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MediClaim_Rejection {

  static int id = 0;

  public void rejectStatus(String name) {
    Connection connection = DbConnection.connectDB();
    try {
      Statement statement = connection.createStatement();
      String query1 = "SELECT Medical_ID from MediclaimRequests WHERE name ='" + name + "';";
      ResultSet rs = statement.executeQuery(query1);
      while (rs.next()) {
        id = rs.getInt("Medical_ID");
      }
      String query2 = "UPDATE MediclaimRequests SET approved_status = 'rejected' WHERE Medical_ID ='" + id + "' ;";
      statement.executeUpdate(query2);
    } catch (SQLException throwables) {
      System.out.println("Exception caught " + throwables);
    }
  }

}
