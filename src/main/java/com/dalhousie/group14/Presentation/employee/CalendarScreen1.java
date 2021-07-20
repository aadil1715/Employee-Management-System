package com.dalhousie.group14.Presentation.employee;

import com.dalhousie.group14.Presentation.Common.UserInput;
import java.sql.SQLException;

public class CalendarScreen1 implements CalendarScreen {
    public void displayScreen() throws SQLException {
        System.out.println("1. Display your schedule");
        System.out.println("2. Add an event in your calendar.");
        System.out.println("3. Modify an event in your calendar");
        System.out.println("4. Delete/Remove an event from your calendar");
        System.out.println("5. Exit");
        int choice = UserInput.takeInt();
        switch(choice){
            case 1:
                CalendarScreen2 cs2 = new CalendarScreen2();
                cs2.displayScreen();
            case 2:


            case 5:
                System.out.println("PREVIOUS SCREEN!");
                break;
            default:
                System.out.println("Enter a correct choice");
                displayScreen();
        }
    }

    public static void main(String[] args) throws SQLException {
        CalendarScreen1 cs = new CalendarScreen1();
        cs.displayScreen();
    }
}
