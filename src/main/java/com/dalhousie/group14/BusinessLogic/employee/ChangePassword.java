package com.dalhousie.group14.BusinessLogic.employee;

import com.dalhousie.group14.Database.employee.DisplayEmployeeLoginInfo;
import com.dalhousie.group14.Database.employee.UpdatePassword;
import com.dalhousie.group14.Presentation.employee.TakeInputsFromEmployee;

import java.util.HashMap;

/* Author- Jainam Shah(B00883898)
* This class implement the IChangePassword interface.
* This class for update the userName and Password.
*/
public class ChangePassword implements IChangePassword {

  //public static void main(String[] args) {
  UpdatePassword updatePassword = new UpdatePassword();

  DisplayEmployeeLoginInfo displayEmployeeLoginInfo = new
      DisplayEmployeeLoginInfo();

  @Override
  /* This method update the userName and Password.
   */
  public void changePassword() {

    HashMap<String, String> hashMap;
    TakeInputsFromEmployee tip = new TakeInputsFromEmployee();
    String username;
    String password;

    hashMap = tip.getUserNamePassword();

    username = hashMap.get("UserName");
    password = hashMap.get("Password");

    updatePassword.updatePassword(username, password);
    displayEmployeeLoginInfo.displayEmployeeLoginInfo(username);

  }
}

