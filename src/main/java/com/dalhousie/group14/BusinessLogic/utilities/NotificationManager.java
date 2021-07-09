package com.dalhousie.group14.BusinessLogic.utilities;

import com.dalhousie.group14.Database.utilities.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class NotificationManager {
    Connection connection = DbConnection.connectDB();

    public NotificationManager() throws SQLException {

    }

    // Use this method to send a notification by passing a notification object
    public void send(Notification notification, String empID, String managerID) throws SQLException {
        Statement statement = connection.createStatement();
        String sql = "INSERT INTO `notification`(msg,managerID,empID,seen,priority) VALUE ('" + notification.getMsg() + "','" + managerID + "','" + empID + "','" + notification.getSeen() + "','" + notification.getPriority() + "')";
        statement.executeUpdate(sql);
        System.out.println("Successfully sent notification!");
    }

    // Use this method to get notifications by passing an employeeID.
    public void getNotifications(String empID) throws SQLException {
        Statement statement = connection.createStatement();
        String sql = "SELECT * from `notification` where empID ='" + empID + "'";
        ResultSet rs = statement.executeQuery(sql);
        Notification notification1 = new Notification();
        rs.next();
        if (rs != null) {
            notification1.setMsg(rs.getString("msg"));
            notification1.setPriority(rs.getString("priority"));
            notification1.setSeen(1);
            Statement statement2 = connection.createStatement();
            sql = "UPDATE `notification` set `seen` ='" + notification1.getSeen() + "'";
            statement2.executeUpdate(sql);
            notification1.display();
        }
    }
}
