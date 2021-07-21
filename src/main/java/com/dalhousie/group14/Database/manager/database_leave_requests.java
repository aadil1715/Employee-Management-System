package com.dalhousie.group14.Database.manager;

import com.dalhousie.group14.Database.utilities.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class database_leave_requests {
    public void select_leave_requests()
    {
        try
        {
            Connection connection=null;
            connection= DbConnection.connectDB();
            String query="SELECT RequestID, EmployeeID, ManagerID, FromDate, ToDate, days, RemainingLeaves,Reason, ApprovedStatus from LeaveRequest";
            Statement stmt=connection.createStatement();
            ResultSet rs= stmt.executeQuery(query);
            while(rs.next())
            {
                  System.out.printf("%10s %15s %30s %35s %30s %30s %30s %30s %30s",rs.getInt("EmployeeID"),
                          rs.getInt("ManagerID"), rs.getInt("RequestID"), rs.getDate("FromDate"),
                          rs.getDate("ToDate"), rs.getInt("days"), rs.getInt("RemainingLeaves"),
                          rs.getString("Reason"), rs.getString("ApprovedStatus"));
                  System.out.println();
            }
        }
        catch(SQLException throwables)
        {
            throwables.printStackTrace();
        }
    }
}
