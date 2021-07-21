package com.dalhousie.group14.BusinessLogic.employee;

import com.dalhousie.group14.Presentation.employee.Employee_Mediclaim_Request;

public interface ValidationInterface {
  Employee_Mediclaim_Request emr = new Employee_Mediclaim_Request();
  String pattern5="^[a-zA-Z_\\s]*$";
  boolean validateName(String name);
  boolean validatePolicyNumber(int policynumber);
  boolean validateMoneyClaimed(int amount);
  boolean validateReason(String reason);
}
