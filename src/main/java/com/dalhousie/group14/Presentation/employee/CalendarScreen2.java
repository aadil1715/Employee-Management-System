package com.dalhousie.group14.Presentation.employee;

import com.dalhousie.group14.Presentation.Common.UserInput;
import com.dalhousie.group14.Presentation.utilities.CalendarDisplay;

import java.sql.SQLException;
import java.time.LocalDate;

public class CalendarScreen2 implements CalendarScreen{
    public void displayScreen() throws SQLException {
        System.out.println("1. Display the current month schedule.");
        System.out.println("2. Display schedule for the next 3 months.");
        System.out.println("3. Display schedule for the entire year.");
        System.out.println("4. Go back to the previous screen.");
        int choice = UserInput.takeInt();
        CalendarDisplay calendarDisplay = new CalendarDisplay();
        LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.getYear();
        int currentMonth = currentDate.getMonth().getValue();
        switch(choice){
            case 1:
                calendarDisplay.displayCurrentMonth(currentYear,currentMonth);
                displayScreen();

            case 2:
                calendarDisplay.displayThreeMonths(currentYear,currentMonth);
                displayScreen();

            case 3:
                calendarDisplay.display(currentYear);
                displayScreen();

            case 4:
                CalendarScreen1 cs1 = new CalendarScreen1();
                cs1.displayScreen();

            default:
                System.out.println("Please enter a correct choice!");
                displayScreen();
        }
    }
}
