package com.dalhousie.group14.Database.manager;

import com.dalhousie.group14.Database.utilities.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class database_mediclaim_requests {
  public void display_mediclaim_requests() {
    try {
      Connection connection= DbConnection.connectDB();
      Statement statement= connection.createStatement();
      String query="SELECT name, policy_number,Medical_ID,money_claimed,reason, approved_status from MediclaimRequests";
      ResultSet rs=statement.executeQuery(query);
      while(rs.next()) {
        System.out.printf("%10s %15s %35s %30s %30s %30s",rs.getString("name"),rs.getInt("policy_number"),
                rs.getInt("Medical_ID"),rs.getLong("money_claimed"),
                rs.getString("reason"),rs.getString("approved_status"));
        System.out.println();
      }

    } catch(SQLException throwables) {
      throwables.printStackTrace();
    }
  }
}
