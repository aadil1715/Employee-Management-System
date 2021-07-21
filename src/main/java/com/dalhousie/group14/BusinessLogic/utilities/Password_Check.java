package com.dalhousie.group14.BusinessLogic.utilities;


import com.dalhousie.group14.Presentation.utilities.login;

public class Password_Check {

  public void password_Check(String password) {
    login l = new login();
    if (password.equals(null)) {
      System.out.println("Password cannot be null");
      l.login2();
    }

    String result;
    int length = 0;
    int numCount = 0;
    int capCount = 0;

    for (int i = 0; i < password.length(); i++) {
      if (password.charAt(i) >= 47 && password.charAt(i) <= 58 || password.charAt(i) >= 64 && password.charAt(i) <= 96 ||
              password.charAt(i) >= 97 && password.charAt(i) <= 122 || password.charAt(i) >= 32 && password.charAt(i) <=47) {

      } else {
        System.out.println("password contains invalid character");

      }
      if (password.charAt(i) > 47 && password.charAt(i) < 58) {
        numCount++;
      }
      if (password.charAt(i) > 64 && password.charAt(i) < 91) {
        capCount++;
      }
      length = (i + 1);
    }

    if (numCount < 2) {
      result = "password does not contain enough numbers";
      System.out.println(result);
      l.login2();
    } else if (capCount < 2) {
      result = "password does not contain enough capital letters";
      System.out.println(result);
      l.login2();
    } else if (length < 8) {
      result = "password is too short";
      System.out.println(result);
      l.login2();
    } else {
      System.out.println("password is valid");
    }


  }

}


