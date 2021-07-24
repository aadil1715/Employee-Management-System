package com.dalhousie.group14.Presentation.manager;

import java.util.Scanner;

/**
 * This is Manager Login Dashboard. After successfully login manager redirect
 * to this page. Manager has option to select.
 */
public class ManagerLoginDashBoard {

  public void managerLoginDashBoard() {

    Scanner scanner = new Scanner(System.in);
    ManageEmployee ManageEmployee = new ManageEmployee();
    ProjectManagement projectManagement=new ProjectManagement();
    IRequestForApprovals request = new RequestForApprovals();

    System.out.println("\t\t\t\t\t\t\t\t\t\t\t\tWelcome to Manager Dashboard\t\t\t\t\t\t\t\t\t\t\t\t");

    System.out.println("Please Select the number from following Options:");


    int select;
    boolean decision = true;
    do {
      try {
        System.out.println("Enter 1 for ManageEmployee:\nEnter 2 for Approve Requests:" +
            "\nEnter 3 for Project Management:\nEnter 4 for Performance " +
            "Evaluation:\nEnter 5 for Notifications:\nEnter 6 for Employee " +
            "Schedule Management:\nEnter 7 for Employee Salary " +
            "Management\nEnter 8 for Logout\nEnter 9 for exit from this page.");
        select = scanner.nextInt();
        switch (select) {
          case 1:
            ManageEmployee.manageEmployee();
            System.out.println("ManageEmployee");
            break;
          case 2:
            request.requestForApprovals();
            System.out.println("Requests");
            break;
          case 3:
            projectManagement.projectManagement();
            System.out.println("Project Management");
            break;
          case 4:
            System.out.println("Performance Evaluation");
            break;
          case 5:
            System.out.println("Notifications");
            break;
          case 6:
            System.out.println("Employee Schedule Management");
            break;
          case 7:
            System.out.println("Employee Salary Management");
            break;
          case 8:
            System.out.println("Logout");
            break;
          case 9:
            decision = false;
            break;
          default:
            System.out.println("Enter Correct number:");
        }
      } catch (Exception e) {
        System.out.println("Exception in ManagerLoginDashboard" + e);
      }
    } while (decision);
  }
}
