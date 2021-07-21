package com.dalhousie.group14.Database.manager;

import com.dalhousie.group14.Database.utilities.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class database_asset_requests {
    public void select_asset_requests()
    {
        try
        {
            Connection connection=null;
            connection= DbConnection.connectDB();
            String query="SELECT EmployeeID, ManagerID, RequestID, AssetName, RequestDate, Reason, ApprovedStatus from AssetRequest";
            Statement stmt=connection.createStatement();
            ResultSet rs= stmt.executeQuery(query);
            while(rs.next())
            {
                System.out.printf("%10s %15s %30s %35s %30s %30s %30s",rs.getInt("EmployeeID"),
                        rs.getInt("ManagerID"), rs.getInt("RequestID"), rs.getString("AssetName"),
                        rs.getDate("RequestDate"), rs.getString("Reason"), rs.getString("ApprovedStatus"));
                System.out.println();
            }
        }
        catch(SQLException throwables)
        {
            throwables.printStackTrace();
        }
    }
}
