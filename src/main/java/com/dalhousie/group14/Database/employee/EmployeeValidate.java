package com.dalhousie.group14.Database.employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.dalhousie.group14.Database.utilities.DbConnection.connectDB;
import static com.dalhousie.group14.Database.utilities.DbConnection.connection;
import static com.dalhousie.group14.Presentation.employee.EmployeeLoginDashBoard.employeeLoginDashBoard;

public class EmployeeValidate {

    public static void employeeValidate(String user_name, String ans) {
        Statement statement;
        ResultSet resultSet;
        String query, ans1 = null, ans2 = null, ans3 = null;
        query = "select * from securityanswer where UserName='" + user_name + "'";

        try {
            connectDB();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                ans1 = resultSet.getString("securityAnswer1");
                ans2 = resultSet.getString("securityAnswer2");
                ans3 = resultSet.getString("securityAnswer3");
            }
            if (ans.equalsIgnoreCase(ans1)) {
                employeeLoginDashBoard();
            } else if (ans.equalsIgnoreCase(ans2)) {
                employeeLoginDashBoard();
            } else if (ans.equalsIgnoreCase(ans3)) {
                employeeLoginDashBoard();
            } else {
                System.out.println("Please enter correct value:");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
