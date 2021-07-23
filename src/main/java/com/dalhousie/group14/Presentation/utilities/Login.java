package com.dalhousie.group14.Presentation.utilities;

import com.dalhousie.group14.BusinessLogic.utilities.*;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Scanner;

/*@Author:Ria Shah
  @Name of File: Login.java
  @Class Description: This class will allow the user to enter the usertype,
  username, and password details. It will also invoke the validation functions
  for username and password.It will also enter the login details in the
  database.
 */
public class Login implements ILogin {

  private IEnterCredentials enter_credentials = new EnterCredentials();

  public void userType() {
    HashMap<String, String> userType = new HashMap<>();
    IUserTypeCheck userTypeCheck = new UserTypeCheck();
    String usertype = null;
    Scanner scanner = new Scanner(System.in);
    System.out.println("PLEASE SELECT THE USER TYPE: \n\n1) EMPLOYEE \n\n2)" +
        " MANAGER \n\n3) CLIENT \n\n4) NEW EMPLOYEE");

    int user = scanner.nextInt();
    if (userTypeCheck.usertypeCheck(user) == true) {
      switch (user) {
        case 1:
          System.out.println("You are an employee!");
          usertype = "Employee";
          enterUsername();
          enterPassword();
          loginTime();
          break;
        case 2:
          System.out.println("You are a manager!");
          usertype = "Manager";
          enterUsername();
          enterPassword();
          loginTime();
          break;
        case 3:
          System.out.println("You are a client!");
          usertype = "Client";
          enterUsername();
          enterPassword();
          loginTime();
          break;
        case 4:
          System.out.println("You are a new employee");
          usertype = "New user";
          enterUsername();
          enterPassword();
          loginTime();
          break;
        default:
          System.out.println("Please select another option");

      }
      userType.put("userType", usertype);
      enter_credentials.credentials(userType);
    } else {
      System.out.println("You have entered invalid option. Please try again.");
      userType();
    }
  }


  public void enterPassword() {
    IPasswordCheck passwordobject = new PasswordCheck();
    HashMap<String, String> passwords = new HashMap<>();
    Scanner scanner = new Scanner(System.in);
    // take the user input for password
    System.out.println("Enter the password");
    String password = scanner.nextLine();
    System.out.println("Password is " + password);
    passwordobject.passwordCheck(password);
    passwords.put("Password", password);
    enter_credentials.credentials(passwords);

  }


  public void enterUsername() {
    IUsernameCheck usernameobject = new UsernameCheck();
    HashMap<String, String> userName = new HashMap<>();
    Scanner scanner = new Scanner(System.in);
    // Take the user input for username
    System.out.println("Enter the username");
    String username = scanner.nextLine();
    usernameobject.usernameCheck(username);
    userName.put("UserName", username);
    enter_credentials.credentials(userName);

  }

  public void loginTime() {
    LocalTime time = LocalTime.now();
    String finalTime = time.toString();
    HashMap<String, String> time1 = new HashMap<>();
    time1.put("time", finalTime);
    enter_credentials.credentials(time1);
  }

}
