package com.dalhousie.group14.BusinessLogic.utilities;

public class UserTypeCheck implements IUserTypeCheck{
  public boolean usertypeCheck(int option) {
    if(option==1 || option ==2 || option ==3 || option ==4) {
      return true;
    } else {
      return false;
    }

  }

}
