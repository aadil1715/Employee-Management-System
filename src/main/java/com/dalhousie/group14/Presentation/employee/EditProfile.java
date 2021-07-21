package com.dalhousie.group14.Presentation.employee;

import java.util.Scanner;

import com.dalhousie.group14.BusinessLogic.employee.ChangePassword;
import com.dalhousie.group14.BusinessLogic.employee.ChangeSecurityQuestion;

public class EditProfile {

  public void editProfile() {

    ChangeSecurityQuestion changeSecurityQuestion =
        new ChangeSecurityQuestion();

    EmployeeLoginDashBoard employeeLoginDashBoard = new EmployeeLoginDashBoard();

    ChangePassword changePassword = new ChangePassword();
    Scanner scanner = new Scanner(System.in);
    int number;
    System.out.println("Press 1 for Edit Password: \n " +
        "Press 2 for Change Security Question: \n " +
        "Press 3 for Goto the Previous Page:");
    number = scanner.nextInt();

    try {
      switch (number) {
        case 1:
          changePassword.changePassword();
          break;
        case 2:
          changeSecurityQuestion.changeSecurityQuestion();
          break;
        case 3:
          employeeLoginDashBoard.employeeLoginDashBoard();
          break;
        default:
          System.out.println("enter valid number:");
          break;
      }

    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
