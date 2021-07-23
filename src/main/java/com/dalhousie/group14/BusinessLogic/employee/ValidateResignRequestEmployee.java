package com.dalhousie.group14.BusinessLogic.employee;


public class ValidateResignRequestEmployee implements IValidateResignRequestEmployee{

  public boolean validateName(String name) {
    if (!name.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")) {
      return false;
    } else {
      return true;
    }
  }

  public boolean validateReason(String reason) {
    if (!reason.matches("[a-zA-Z_\\s]*$")) {
      return false;
    } else {
      return true;
    }
  }

}