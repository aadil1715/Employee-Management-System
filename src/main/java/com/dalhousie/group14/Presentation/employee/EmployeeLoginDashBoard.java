package com.dalhousie.group14.Presentation.employee;

/*This page for Employee login dashboard where employee has options to
edit profile
request for leave
request for medicliam
request for asset
request for resign.
*/

import com.dalhousie.group14.BusinessLogic.employee.RequestForLeave;

import java.util.Scanner;

public class EmployeeLoginDashBoard {

  public void employeeLoginDashBoard() {

    EditProfile editProfile = new EditProfile();
    RequestForLeave request = new RequestForLeave();
    System.out.println("Welcome to Login Dashboard");
    Scanner scanner = new Scanner(System.in);
    System.out.println("Select any of the following task to perform.");
    System.out.println("Select 1 for Edit Profile:\nSelect 2 for " +
        "Calender\nSelect 3 for Joining Request:\nSelect 4 for Leave " +
        "Request:\nSelect 5 for Mediclaim Request:\nSelect 6 for Asset Request:\nSelect 7 for Resign Request:");

    int select;
    select = scanner.nextInt();
    switch (select) {
      case 1:
        editProfile.editProfile();
        break;
      case 2:
        System.out.println("See Calender:");
        break;
      case 3:
        System.out.println("Joining Request");
        break;
      case 4:
        request.requestForLeave();
    }
  }
}
