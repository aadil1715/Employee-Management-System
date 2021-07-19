package com.dalhousie.group14.BusinessLogic.employee;

import com.dalhousie.group14.Database.employee.NewEmployee;

import java.util.Map;

public class NewEmployeeBusiness {


  public Boolean Login(String UserName, String Password) {
    Map<String,String> info;
    NewEmployee nd=new NewEmployee();
    info=nd.getNewEmployeeInfo(UserName);
    if(Password.equals(info.get("password"))) {

    }
    return true;

  }


}
