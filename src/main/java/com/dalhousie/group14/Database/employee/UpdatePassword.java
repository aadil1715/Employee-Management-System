package com.dalhousie.group14.Database.employee;

import java.sql.SQLException;
import java.sql.Statement;

import static com.dalhousie.group14.Database.utilities.DbConnection.connectDB;
import static com.dalhousie.group14.Database.utilities.DbConnection.connection;

public class UpdatePassword {
    public static void updatePassword(String username, String password) {
        Statement statement;
        int resultSet;

        String query = "UPDATE `ems`.`LoginInfo` SET `Password` = '" + password + "' WHERE (`UserName` = '" + username + "')";
        try{
            connectDB();
            statement = connection.createStatement();
            resultSet = statement.executeUpdate(query);
            if (resultSet > 0) {
                System.out.println("Update Successfully");
            } else {
                System.out.println("Password not update please check your employee id.");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
