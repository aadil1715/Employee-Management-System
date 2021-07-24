package com.dalhousie.group14.Presentation.utilities;

import com.dalhousie.group14.BusinessLogic.employee.CalendarEvent;
import com.dalhousie.group14.Database.employee.EventOperations;
import com.dalhousie.group14.Database.utilities.GetSpecialDates;
import com.dalhousie.group14.Database.utilities.QueryExecutor;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CalendarDisplayTest {
    @Test
    public void display() throws SQLException {
        List<Long> fetchedSpecialDates = new ArrayList<>();
        GetSpecialDates getSpecialDatesObject = new GetSpecialDates();
        fetchedSpecialDates =
            getSpecialDatesObject.getSpecialDatesForEmployee("891000");
        System.out.println(fetchedSpecialDates);
    }

    @Test
    public void displaySpecial() throws SQLException {
        List<String> dates = new ArrayList<>();
        String query = "SELECT eventDate from `Calendar` where empID='" + 891000 + "'";
        ResultSet rs;
        rs = QueryExecutor.readData(query);
        while(rs != null && rs.next()){
            String date = rs.getString("eventDate");
            dates.add(date);
        }
        for(String dt : dates) {
            String year = dt.substring(0,4);
            String month = dt.substring(5,7);
            String dte = dt.substring(8,10);
            System.out.println(year);
            System.out.println(month);
            System.out.println(dte);
        }
    }

    @Test
    public void temp() throws SQLException {
        System.out.println("Enter a date to look at the event details: ");
        CalendarEvent e = CalendarEvent.searchEvent("2021-08-05");
        e.display();
    }

}