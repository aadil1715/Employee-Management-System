package com.dalhousie.group14.BusinessLogic.utilities;

import java.util.regex.Pattern;
import com.dalhousie.group14.Database.utilities.checkUsernameExists;
import com.dalhousie.group14.Presentation.utilities.login;
import com.dalhousie.group14.Presentation.utilities.print;


public class Username_Check {

  public void username_Check(String name) {
    print p1 = new print();
    login l = new login();
    // regex to check the valid username
    String regex1 = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
    //Compile the regex
    Pattern p = Pattern.compile(regex1);
    boolean valid = (name != null) && p.matcher(name).matches();
    checkUsernameExists object = new checkUsernameExists();
    if (object.checkUsernameExists(name) == false) {
      System.out.println("its a new record of username");
    } else {
      System.out.println("username already exists.Try again");
      l.login1();
    }
    String message;
    if (valid) {

      message = "Username is valid";
      System.out.println(p1.display_message(message));

    } else {

      message = "Username is not valid";
      System.out.println(p1.display_message(message));
      l.login1();
    }


  }

}
