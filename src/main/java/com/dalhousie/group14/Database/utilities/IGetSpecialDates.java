package com.dalhousie.group14.Database.utilities;

import java.util.List;

public interface IGetSpecialDates {
  List<Long> getSpecialDates();
  List<Long> getSpecialDatesForEmployee(String empID);

}