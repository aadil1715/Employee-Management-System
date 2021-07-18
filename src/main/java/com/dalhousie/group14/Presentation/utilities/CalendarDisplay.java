package com.dalhousie.group14.Presentation.utilities;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Scanner;

public class CalendarDisplay implements ICalendarDisplay{

    public void displayMonths(int year, int month) {
                YearMonth ym = YearMonth.of(year, month);
                System.out.println("Sun Mon Tue Wed Thu Fri Sat");
                int counter = 1;

                int dayValue = LocalDate.of(year, month, 1).getDayOfWeek().getValue();
                if (dayValue != 7)
                    for (int i = 0; i < dayValue; i++, counter++) {
                        System.out.printf("%-4s", "");
                    }

                for (int i = 1; i <= ym.getMonth().length(ym.isLeapYear()); i++, counter++) {
                    System.out.printf("%-4d", i);

                    if (counter % 7 == 0) {
                        System.out.println();
                    }
                }
                System.out.println();
                System.out.println();
            }

    @Override
    public void display(int year) {
        for(int i=start_month;i<=total_months;i++)
        {
            displayMonths(year,i);
        }
    }
}
