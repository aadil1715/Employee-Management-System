package com.dalhousie.group14.Presentation.utilities;

import java.time.LocalDate;
import java.time.YearMonth;

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
                    if(ym.getMonth().toString().equals("AUGUST") && i==1)
                    {
                        System.out.printf("\033[4m%-2s\033[0m",i);
                        System.out.printf("%-2s", "");
                    }
                    else if(ym.getMonth().toString().equals("JANUARY") && i==2){
                        System.out.printf("\033[4m%-2s\033[0m",i);
                        System.out.printf("%-2s", "");
                    }
                    else{
                        System.out.printf("%-4d",i);
                    }

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
            System.out.println(LocalDate.of(year,i,1).getMonth().toString());
            displayMonths(year,i);
        }
    }
}
