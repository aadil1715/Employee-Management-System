package com.dalhousie.group14.Database.employee;

import com.dalhousie.group14.BusinessLogic.employee.CalendarEvent;
import com.dalhousie.group14.Database.utilities.QueryExecutor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class getEvent {
    public static List<String> searchEventByDate(String eventDate) throws SQLException {
        String query = "SELECT `eventName`, `eventDescription` FROM `Calendar` WHERE eventDate = '" + eventDate + "'";
        ResultSet rs = QueryExecutor.readData(query);
        List<String> eventInfo = new ArrayList<>();
        while(rs != null && rs.next()){
            System.out.println();
            eventInfo.add(rs.getString("eventName"));
            eventInfo.add(rs.getString("eventDescription"));
        }
        return eventInfo;
    }

    public static void searchEventAndModify(CalendarEvent e, String old_date) throws SQLException {
        System.out.println(e.getEventDate());
        String query = "UPDATE `Calendar` SET `eventName` = '" + e.getEventName() + "',"
                + " `eventDescription` = '" + e.getEventDescription() + "',"
                + "`eventDate` = '" + e.getEventDate() + "'" + "WHERE `eventDate` = '" + old_date + "'";
        QueryExecutor.writeData(query);
    }


}
