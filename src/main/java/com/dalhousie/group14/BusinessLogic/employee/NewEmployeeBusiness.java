package com.dalhousie.group14.BusinessLogic.employee;

import com.dalhousie.group14.Database.employee.NewEmployee;

import java.util.HashMap;
import java.util.Map;

public class NewEmployeeBusiness {


  public Boolean Login(String UserName, String Password) {
    Map<String,String> info=new HashMap<>();
    NewEmployee nd=new NewEmployee();
    info=nd.getNewEmployeeInfo(UserName);

    if(Password.equals(info.get("Password"))) {

      NewEmployeeBusiness newEmployeeBusiness=new NewEmployeeBusiness();
      newEmployeeBusiness.applyjoinRequest();
      return true;
    }
    else{
      System.out.println("Incorrect Login or Password Please Try again");
      return false;
    }


  }

  public void applyjoinRequest(){


  }

  public  boolean userNameValidtion(String userName){
    if(userName != null){
      for(int i = 0; i < userName.length(); i++){
        if(Character.isWhitespace(userName.charAt(i))||userName.charAt(i)=='@'||userName.charAt(i)=='!'||userName.charAt(i)=='#'||userName.charAt(i)=='$'||userName.charAt(i)=='%'||userName.charAt(i)=='^'||userName.charAt(i)=='&'||userName.charAt(i)=='*'||userName.charAt(i)=='('||userName.charAt(i)==')'||userName.charAt(i)=='-'||userName.charAt(i)=='_'||userName.charAt(i)=='+'||userName.charAt(i)=='='){
          return true;
        }
      }
    }
    return false;
  }


}
