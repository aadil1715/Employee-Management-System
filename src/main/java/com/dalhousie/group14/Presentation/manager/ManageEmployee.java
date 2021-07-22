package com.dalhousie.group14.Presentation.manager;

import java.util.Scanner;

public class ManageEmployee {

  public void manageEmployee() {

    Scanner scanner = new Scanner(System.in);
    ManagerLoginDashBoard managerLoginDashBoard =
        new ManagerLoginDashBoard();

    EditEmployeeInformation employeeInformation =
        new EditEmployeeInformation();

    System.out.println("\t\t\t\t\t\t\t\t\t\t\t\tWelcome to Manage Employee Page:\t\t\t\t\t\t\t\t\t\t\t\t");

    System.out.println("Select any of the following task to perform on " +
        "Employee:");

    int select;
    boolean decision = true;
    do {
      try {
        System.out.println("Select 1 for Edit Employee Information:\nSelect 2" +
            " for Update Calende:\nSelect 3 for Send a Notification:\nSelect 4 for " +
            "the Manage the Salary:\nSelect 5 for Map this Employee to the " +
            "project:\nSelect 6 for go to the Manager DashBoard Page:\nSelect" +
            " 7 for exit.");
        select = scanner.nextInt();

        switch (select) {
          case 1:
            employeeInformation.editEmployeeInformation();
            break;
          case 2:
            System.out.println("Update Calender");
            break;
          case 3:
            System.out.println("Send a Notification");
            break;
          case 4:
            System.out.println("Salary");
            break;
          case 5:
            System.out.println("Map Employee to the project");
            break;
          case 6:
            managerLoginDashBoard.managerLoginDashBoard();
            break;
          case 7:
            decision=false;
          default:
            System.out.println("Enter Correct number:");
        }
      } catch (Exception e) {
        System.out.println("Exception in ManageEmployee class" + e);
      }
    } while(decision);
  }
}
