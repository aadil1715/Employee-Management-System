package com.dalhousie.group14.Database.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    Connection connection;
    public static Connection connectDB() {
        final String url = "jdbc:mysql://34.134.143.1/ems";
        final String username = "root";
        final String password = "ahjnr5";
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            return connection;
        } catch (SQLException throwables) {
            return null;
        }
    }
}