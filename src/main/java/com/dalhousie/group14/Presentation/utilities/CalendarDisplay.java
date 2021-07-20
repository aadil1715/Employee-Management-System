package com.dalhousie.group14.Presentation.utilities;

import com.dalhousie.group14.Database.utilities.QueryExecutor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.zip.CRC32;

public class CalendarDisplay implements ICalendarDisplay{
    private final List<Long> testD = new ArrayList<>();

    public void displayMonths(int year, int month) {
                YearMonth ym = YearMonth.of(year, month);

                int counter = 1;

                System.out.println("Sun Mon Tue Wed Thu Fri Sat");
                int dayValue = LocalDate.of(year, month, 1).getDayOfWeek().getValue();
                if (dayValue != 7) {
                    for (int i = 0; i < dayValue; i++, counter++) {
                        System.out.printf("%-4s", "");
                    }
                }

                for (int i = 1; i <= ym.getMonth().length(ym.isLeapYear()); i++, counter++) {
                    CRC32 hash = new CRC32();
                    hash.reset();
                    hash.update(String.format("%d_%d", ym.getMonth().getValue(), i).getBytes());

                        if (testD.contains(hash.getValue())) {
                            System.out.printf("\033[4m%-2s\033[0m", i);
                            System.out.printf("%-2s", "");
                        }
                        else {
                            System.out.printf("%-4d", i);
                        }

                    if (counter % 7 == 0) {
                        System.out.println();
                    }
                }
                System.out.println();
                System.out.println();
            }

    @Override
    public void display(int year) throws SQLException {
        String query = "SELECT eventDate from `Calendar` where empID='" + 891000 + "'";
        ResultSet rs;
        rs = QueryExecutor.readData(query);
        while(rs != null && rs.next()){
            String date = rs.getString("eventDate");
            int special_year = Integer.parseInt(date.substring(0,4));
            int special_month = Integer.parseInt(date.substring(5,7));
            int special_date = Integer.parseInt(date.substring(8,10));

            CRC32 hash = new CRC32();
            hash.reset();
            hash.update(String.format("%d_%d", special_month, special_date).getBytes());
            testD.add(hash.getValue());
        }
        for(int i=start_month;i<=total_months;i++)
        {
            System.out.println(LocalDate.of(year,i,1).getMonth().toString());
            displayMonths(year,i);
        }
    }
}
