package com.dalhousie.group14.BusinessLogic.employee;

import java.lang.Override;

public class Validation implements IValidation {

  int flag = 0;

  public int getFlag() {
    return this.flag;
  }

  @Override
  public boolean validateName(String name) {
    if (name.matches(pattern5)) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public boolean validatePolicyNumber(int policynumber) {
    if (policynumber < 0 || policynumber == 0) {
      flag = 1;
      return false;
    } else {
      return true;
    }

  }

  @Override
  public boolean validateMoneyClaimed(int amount) {
    if (amount < 0 || amount == 0) {
      return false;
    } else {
      return true;
    }
  }

  @Override
  public boolean validateReason(String reason) {
    if (!reason.matches(pattern6)) {
      return false;
    } else {
      return true;
    }
  }

}

