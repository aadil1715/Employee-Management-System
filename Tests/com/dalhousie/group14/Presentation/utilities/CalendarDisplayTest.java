package com.dalhousie.group14.Presentation.utilities;

import com.dalhousie.group14.Database.utilities.QueryExecutor;
import com.dalhousie.group14.Presentation.Common.UserInput;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class CalendarDisplayTest {
    @Test
    public void display() {
        int year = 2021;
        CalendarDisplay cd = new CalendarDisplay();
        cd.display(year);
    }

    @Test
    public void displaySpecial() throws SQLException {
        String query = "SELECT eventDate from `Calendar` where empID='" + 891000 + "'";
        ResultSet rs;
        rs = QueryExecutor.readData(query);
        while(rs.next()){
            System.out.println(rs.getString("eventDate"));
        }

    }
}