package com.dalhousie.group14.BusinessLogic.employee;


public interface IValidation {

  String pattern5 ="^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";

  String pattern6= "^[a-zA-Z0-9]+";

  boolean validateName(String name);

  boolean validatePolicyNumber(int policynumber);

  boolean validateMoneyClaimed(int amount);

  boolean validateReason(String reason);

}
