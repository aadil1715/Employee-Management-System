package com.dalhousie.group14.Presentation.employee;

/*Author- Jainam Shah(B00883898)*/
/*This page for Employee login dashboard where employee has options to
edit profile
request for leave
request for medicliam
request for asset
request for resign.
*/

import com.dalhousie.group14.BusinessLogic.employee.IRequestForLeave;
import com.dalhousie.group14.BusinessLogic.employee.RequestForLeave;

import java.util.Scanner;

public class EmployeeLoginDashBoard {

  public void employeeLoginDashBoard() {

    EditProfile editProfile = new EditProfile();
    IRequestForLeave request = new RequestForLeave();
    System.out.println("\t\t\t\t\t\t\t\t\t\t\t\tWelcome to Login Dashboard\t\t\t\t\t\t\t\t\t\t\t\t");
    Scanner scanner = new Scanner(System.in);
    System.out.println("Select any of the following task to perform.");

    int select;
    boolean decisoin = true;
    do {
      try {
        System.out.println("Enter 1 for Edit Profile:\nEnter 2 for " +
            "Schedule Management\nEnter 3 for Salary Management:\nEnter 4 for " +
            "Leave Request:\nEnter 5 for Mediclaim Request:\nEnter 6 for Asset " +
            "Request:\nEnter 7 for Resign From Your Position:\nEnter 8 for " +
            "Project Management");
        select = scanner.nextInt();
        switch (select) {
          case 1:
            editProfile.editProfile();
            break;
          case 2:
            System.out.println("Schedule Management:");
            break;
          case 3:
            System.out.println("Salary Management");
            break;
          case 4:
            request.requestForLeave();
            break;
          case 5:
            System.out.println("Mediclaim Request");
            break;
          case 6:
            System.out.println("Asset");
            break;
          case 7:
            System.out.println("Resign");
            break;
          case 8:
            System.out.println("Project Management");
            break;
          case 9:
            System.out.println("LOGOUT");
            break;
          case 10:
            decisoin = false;
          default:
            System.out.println("Enter Valid Number");
        }
      } catch (Exception e) {
        System.out.println("Your Exception:" + e);
        employeeLoginDashBoard();
      }
    } while (decisoin);
  }
}
