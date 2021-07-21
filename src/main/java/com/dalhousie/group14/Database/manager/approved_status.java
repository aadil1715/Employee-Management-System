package com.dalhousie.group14.Database.manager;

import com.dalhousie.group14.Database.utilities.DbConnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class approved_status {

  public void approve_status(int id) {
    Connection connection = DbConnection.connectDB();
    String query = "UPDATE ResignRequest SET ApprovedStatus = 'approved' WHERE EmployeeID =" + id + ";";
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
    notice_period_update npu = new notice_period_update();
    npu.notice_period_display(id);

  }

}
