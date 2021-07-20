package com.dalhousie.group14.Presentation.employee;

import com.dalhousie.group14.Presentation.Common.UserInput;

public class CalendarScreen3 implements CalendarScreen{
    public void displayScreen(){
        System.out.println("Enter the date of event (FORMAT - YYYY-MM-DD): ");
        String date = UserInput.takeString();
        System.out.println("Enter the name of event: ");
        String name = UserInput.takeString();
        System.out.println(date);
        System.out.println(name);
    }
}
