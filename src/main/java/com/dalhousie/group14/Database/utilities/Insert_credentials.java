package com.dalhousie.group14.Database.utilities;




import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert_credentials {

    public void insert_credentials(String emailID, String password, String userType)  {
        try {
            DbConnection dbConnection=new DbConnection();
            Connection connection=null;
            connection=dbConnection.connectDB();

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