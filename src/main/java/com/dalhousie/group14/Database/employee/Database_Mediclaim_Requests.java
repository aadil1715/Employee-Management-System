package com.dalhousie.group14.Database.employee;

import com.dalhousie.group14.Database.utilities.DbConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Database_Mediclaim_Requests {

  public void employeeMediclaimRequests(String name, int number, int amount, String reason, String status) {
    Connection connection = DbConnection.connectDB();
    try {
      Statement statement = connection.createStatement();
      String query = "insert into MediclaimRequests(name,policy_number,money_claimed,reason,approved_status) values('" + name + "', '" + number + "','" + amount + "','" + reason + "','" + status + "')";
      statement.executeUpdate(query);
      System.out.println("inserted");
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }

}
