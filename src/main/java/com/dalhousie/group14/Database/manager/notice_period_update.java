package com.dalhousie.group14.Database.manager;

import com.dalhousie.group14.Database.utilities.DbConnection;
import com.dalhousie.group14.BusinessLogic.employee.notice_period;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class notice_period_update {

  public void notice_period_display(int id) {
    notice_period np = new notice_period();
    Connection connection = DbConnection.connectDB();
    long notice_period1 = np.notice_period_calculation();
    System.out.println(notice_period1);
    String query1 = "UPDATE ResignRequest SET NoticePeriod = " + notice_period1 + " WHERE EmployeeID =" + id + ";";
    Statement stmt = null;
    try {
      stmt = connection.createStatement();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }

    try {
      stmt.executeUpdate(query1);
      connection.close();
    } catch (SQLException throwables) {
      throwables.printStackTrace();

    }

  }

}
