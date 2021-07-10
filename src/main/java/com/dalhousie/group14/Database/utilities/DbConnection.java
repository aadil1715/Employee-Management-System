package com.dalhousie.group14.Database.utilities;
import java.sql.*;

public class DbConnection {
        public static Connection connection;
        public static void connectDB() throws SQLException {

                final String url = "jdbc:mysql://34.134.143.1/ems";
                final String username = "root";
                final String password = "ahjnr5";
                connection=DriverManager.getConnection(url, username, password);

                System.out.println("successfully connection");
        }
 }
