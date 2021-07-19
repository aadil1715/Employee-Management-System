package com.dalhousie.group14.Presentation.manager;

import java.util.Scanner;

public class ManageEmployee {

  public void manageEmployee() {

    Scanner scanner = new Scanner(System.in);
    ManagerLoginDashBoard managerLoginDashBoard =
        new ManagerLoginDashBoard();

    EditEmployeeInformation employeeInformation =
        new EditEmployeeInformation();
    System.out.println("Welcome to Manage Employee Page:");
    System.out.println("Select any of the following task to perform on " +
        "Employee:");
    System.out.println("Select 1 for Edit Employee Information:\nPress 2 for " +
        "Update Calender:\n Select 3 for Send a Notification:\n Select 4 for " +
        "the Manage the Salary:\n Select 5 for Map this Employee to the " +
        "project:\n Select 6 for go to the Manager DashBoard Page:");
    int select;
    select = scanner.nextInt();
    switch (select) {
      case 1:
        employeeInformation.editEmployeeInformation();
        System.out.println("Edit Employee Information");
        break;
      case 2:
        System.out.println("Update Calender");
        break;
      case 3:
        System.out.println("Send a Notification");
        break;
      case 4:
        System.out.println("salary");
        break;
      case 5:
        System.out.println("Map Employee to the project");
        break;
      case 6:
        managerLoginDashBoard.managerLoginDashBoard();
    }
  }
}
