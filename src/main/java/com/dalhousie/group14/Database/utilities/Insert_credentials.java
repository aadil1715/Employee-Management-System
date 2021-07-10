package com.dalhousie.group14.Database.utilities;

import static com.dalhousie.group14.Database.utilities.DbConnection.connectDB;
import static com.dalhousie.group14.Database.utilities.DbConnection.connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert_credentials {

    public void insert_credentials(String emailID, String password, String userType)  {
        try {
            connectDB();

            String query="insert into LoginInfo values('"+emailID+"', '"+password+"', '"+userType+"');";
            Statement stmt=connection.createStatement();
            stmt.execute(query);


            System.out.println("inserted");
            connection.close();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}