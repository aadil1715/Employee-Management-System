package com.dalhousie.group14.Presentation.employee;

import com.dalhousie.group14.BusinessLogic.employee.CalendarEvent;
import com.dalhousie.group14.Database.employee.getEvent;
import com.dalhousie.group14.Presentation.Common.UserInput;
import com.dalhousie.group14.Presentation.utilities.CalendarDisplay;

import java.sql.SQLException;
import java.time.LocalDate;

public class CalendarScreen3 implements CalendarScreen{
    public void displayScreen(){
        LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.getYear();
        int currentMonth = currentDate.getMonth().getValue();
        CalendarDisplay calendarDisplay = new CalendarDisplay();
        try {
            calendarDisplay.displayThreeMonths(currentYear,currentMonth);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("Enter the date of event (FORMAT - YYYY-MM-DD): ");
        System.out.println("Please follow the format (YYYY-DD-MM) EG [2021-12-08]");
        String date = UserInput.takeString();
        try {
            CalendarEvent e = CalendarEvent.searchEvent(date);
            if(e.getEventName()!=null){
                System.out.println("Enter the new name of event: ");
                String newname = UserInput.takeString();
                System.out.println("Enter the date of event (FORMAT - YYYY-MM-DD): ");
                System.out.println("Please follow the format (YYYY-DD-MM) EG [2021-12-08].");
                System.out.println("Keep the date as it is if you dont want to change it.");
                String newdate = UserInput.takeString();
                System.out.println("Enter the new description name of event: ");
                String newdesc = UserInput.takeString();
                CalendarEvent enew = new CalendarEvent(newname,newdesc,newdate);
                getEvent.searchEventAndModify(enew,date);
                System.out.println("Updated the event successfully");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        CalendarScreen1 cs1 = new CalendarScreen1();
        cs1.displayScreen();

    }
}
