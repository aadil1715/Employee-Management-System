package com.dalhousie.group14.Database.manager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.dalhousie.group14.Database.utilities.DbConnection;

public class resign_requests {
    public void select_resign_requests()
    {
        try
        {
            Connection connection=null;
            connection=DbConnection.connectDB();
            String query="SELECT EmployeeID, ManagerID, RequestID, ResignDate, NoticePeriod, Reason, ApprovedStatus FROM ResignRequest";
            Statement stmt=connection.createStatement();
            ResultSet rs= stmt.executeQuery(query);

            while(rs.next())
            {
                System.out.println("Employee ID " +rs.getInt("EmployeeID"));
                System.out.println("Manager ID " +rs.getInt("ManagerID"));
                System.out.println("Request ID " +rs.getInt("RequestID"));
                System.out.println("Resign Date" +rs.getDate("ResignDate"));
                System.out.println("Notice Period " +rs.getInt("NoticePeriod"));
                System.out.println("Reason" +rs.getString("Reason"));
                System.out.println("Approved Status" +rs.getString("ApprovedStatus"));
            }
            stmt.close();





        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

