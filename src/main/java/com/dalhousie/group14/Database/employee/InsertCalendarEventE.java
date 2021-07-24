package com.dalhousie.group14.Database.employee;

import com.dalhousie.group14.BusinessLogic.employee.CalendarEvent;
import com.dalhousie.group14.Database.utilities.QueryExecutor;

import java.sql.ResultSet;

public class InsertCalendarEventE {
    public static void insertEvent(CalendarEvent calendarEvent){
        // ADD LOGIC
        String query = "INSERT INTO `Calendar` (eventName,eventDescription,eventDate,empID,createdByManager) VALUES ('"+calendarEvent.getEventName()+"','"+calendarEvent.getEventDescription()+"','"+calendarEvent.getEventDate()+"',"+calendarEvent.getEmpID()+",'"+calendarEvent.getCreatedByManager()+"')";
        QueryExecutor.writeData(query);
    }
}
