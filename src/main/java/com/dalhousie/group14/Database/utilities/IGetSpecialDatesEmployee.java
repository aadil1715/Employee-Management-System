package com.dalhousie.group14.Database.utilities;

import java.util.List;

public interface IGetSpecialDatesEmployee {
  List<Long> getSpecialDatesForEmployee(String empID);
}
