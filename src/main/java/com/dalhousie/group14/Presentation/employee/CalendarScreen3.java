package com.dalhousie.group14.Presentation.employee;

import com.dalhousie.group14.BusinessLogic.employee.CalendarEvent;
import com.dalhousie.group14.Database.employee.getEvent;
import com.dalhousie.group14.Presentation.Common.UserInput;

import java.sql.SQLException;

public class CalendarScreen3 implements CalendarScreen{
    public void displayScreen(){
        System.out.println("Enter the name of event: ");
        String name = UserInput.takeString();
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
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
