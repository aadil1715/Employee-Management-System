package com.dalhousie.group14.BusinessLogic.employee;


import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class NoticePeriod implements INoticePeriod {

  public long noticePeriodCalculation() {
    try {
      LocalDate now = LocalDate.now();
      LocalDate futureDate = LocalDate.now().plusMonths(2);
      long daysBetween = ChronoUnit.DAYS.between(now, futureDate);
      long months = (daysBetween / 30);
      return months;
    } catch (DateTimeException exception) {
      System.out.println("date is not in valid format");
    }
    return 0;
  }


}
