package com.dalhousie.group14.Database.employee;

import com.dalhousie.group14.Database.utilities.DbConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import com.dalhousie.group14.BusinessLogic.employee.notice_period;

public class insert_resign_requests implements approved_status_interface {

  public void insert_resign_request_details(int id, LocalDate date, String reason) {
    try {
      Connection connection = DbConnection.connectDB();
      String query1 = "SET FOREIGN_KEY_CHECKS =0";
      Statement stmt = connection.createStatement();
      stmt.execute(query1);
      notice_period np = new notice_period();
      long noticeperiod1 = np.notice_period_calculation();
      String query = ("insert into ResignRequest(EmployeeID,ResignDate,Reason,ApprovedStatus)" +
              "values('" + id + "','" + date + "','" + reason + "','" + approved_status + "')");
      Statement stmt1 = connection.createStatement();
      stmt.executeUpdate(query);
      String query2 = "SET FOREIGN_KEY_CHECKS =1";
      stmt.execute(query2);

    } catch (SQLException e) {
      e.printStackTrace();
    }

  }

}
