package com.dalhousie.group14.BusinessLogic.utilities;

import java.util.Map;

public interface ISalaries {

  Map viewSalary(String employee);

  boolean updateSalary(String employee, double amount, String salryType);
}
