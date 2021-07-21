package com.dalhousie.group14.Database.manager;

import com.dalhousie.group14.Database.utilities.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class database_schedule {
    public void select_schedule()
    {
        try
        {
            Connection connection=null;
            connection= DbConnection.connectDB();
            String query="SELECT eventType, eventDate, eventTime, eventID from  schedule";
            Statement stmt=connection.createStatement();
            ResultSet rs= stmt.executeQuery(query);
            while(rs.next())
            {
                System.out.printf("%10s %15s %30s %35s",rs.getString("eventType"),rs.getDate("eventDate"),
                        rs.getTime("eventTime"),rs.getInt("eventID"));
                System.out.println();
            }

        }
        catch(SQLException throwables)
        {
            throwables.printStackTrace();
        }
    }
}
