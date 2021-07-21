package com.dalhousie.group14.Presentation.manager;

import java.util.Scanner;

public class resign_requests1 implements resign_requests_interface {

  public void display_resign_requests() {
    System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t-----List of Resignation Requests-----\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
    System.out.printf("%10s %15s %30s %35s %30s %30s %30s", "EMPLOYEE ID", "MANAGER ID", "REQUEST ID", "DATE OF RESIGNATION", "NOTICE PERIOD", "REASON FOR THE RESIGNATION", "APPROVED STATUS\n");
    object3.select_resign_requests();

    System.out.println("Do you want to approve the pending requests? Type Y for yes or N for no");
    Scanner scanner = new Scanner(System.in);
    String string = scanner.next();

    if (string.equalsIgnoreCase("Y")) {
      System.out.println("Please enter the Employee ID you want to approve");
      int employeeid = scanner.nextInt();
      System.out.println("Please enter your Manager Username");
      String username = scanner.next();
      int managerid = getManagerId.getManagerID(username);
      insert_manager_id.insertManagerID(employeeid, managerid);
      System.out.println("You have selected employeeid " + employeeid + " to approve");
      object1.approve_status(employeeid);
    } else if (string.equalsIgnoreCase("N")) {
      System.out.println("Please enter the EmployeeID you want to reject");
      int employeeid = scanner.nextInt();
      System.out.println("You have selected employeeid " + employeeid + " to reject");
      object2.reject_status(employeeid);
    } else {
      object4.validateInput(string);
      display_resign_requests();
      displayUpdatedList();
    }

  }

  public void displayUpdatedList() {
    System.out.println("Below is the updated list of Resign Requests");
    System.out.printf("%10s %15s %30s %35s %30s %30s %30s", "EMPLOYEE ID", "MANAGER ID", "REQUEST ID", "DATE OF RESIGNATION", "NOTICE PERIOD", "REASON FOR THE RESIGNATION", "APPROVED STATUS\n");
    object3.select_resign_requests();
  }

}