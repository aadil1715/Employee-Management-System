package com.dalhousie.group14.BusinessLogic.employee;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class notice_period implements noticePeriodInterface {

  public long notice_period_calculation() {
    LocalDate now = LocalDate.now();
    LocalDate futureDate = LocalDate.now().plusMonths(2);
    long daysBetween = ChronoUnit.DAYS.between(now, futureDate);
    long months = (daysBetween / 30);
    return months;
  }


}
