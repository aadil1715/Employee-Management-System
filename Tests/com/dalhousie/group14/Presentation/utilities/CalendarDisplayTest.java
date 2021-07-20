package com.dalhousie.group14.Presentation.utilities;

import com.dalhousie.group14.Database.utilities.QueryExecutor;
import com.dalhousie.group14.Presentation.Common.UserInput;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CalendarDisplayTest {
    @Test
    public void display() throws SQLException {
        int year = 2021;
        CalendarDisplay cd = new CalendarDisplay();
        cd.display(year);
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
}