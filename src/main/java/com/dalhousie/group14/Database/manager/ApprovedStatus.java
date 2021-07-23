package com.dalhousie.group14.Database.manager;

import com.dalhousie.group14.Database.utilities.DbConnection;
import com.dalhousie.group14.Database.utilities.QueryExecutor;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ApprovedStatus implements IApprovedStatusbyManager {

  public void approveStatus(int id) {
    Connection connection = DbConnection.connectDB();
    String query = "UPDATE ResignRequest SET ApprovedStatus = 'approved' WHERE EmployeeID =" + id + ";";
    Statement stmt = null;
    //      stmt = connection.createStatement();
//      stmt.executeUpdate(query);
    QueryExecutor.writeData(query);

    NoticePeriodDisplay npu = new NoticePeriodDisplay();
    npu.noticePeriodDisplay(id);

  }

}
