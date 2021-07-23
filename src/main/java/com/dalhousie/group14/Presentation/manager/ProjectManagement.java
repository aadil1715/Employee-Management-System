package com.dalhousie.group14.Presentation.manager;

import java.util.Scanner;

public class ProjectManagement {

  public void projectManagement() {
    System.out.println("\t\t\t\t\t\t\t\t\t\t\t\tWelcome to Project Management" +
        "Dashboard\t\t\t\t\t\t\t\t\t\t\t\t");
    System.out.println("Please Select the number from following Options:");
    int select;
    ManagerLoginDashBoard managerLoginDashBoard=new ManagerLoginDashBoard();
    Scanner scanner = new Scanner(System.in);

      try {
        System.out.println("Enter 1 for Employee Selects:\nEnter 2 for " +
            "See Milestone Deadline:\nEnter 4 for Project History\nEnter 5 " +
            "to redirect ManagerLogin Dashboard Page");
        select = scanner.nextInt();
        switch (select) {
          case 1:
            System.out.println("Employee Selects");
            break;
          case 2:
            System.out.println("ManageEmployee");
            break;
          case 3:
            System.out.println("See Milestone Deadline");
            break;
          case 4:
            System.out.println("Project History");
            break;
          case 5:
           managerLoginDashBoard.managerLoginDashBoard();
            break;
          default:
            System.out.println("Enter Right Values");
            break;
        }
      } catch (Exception e) {
        System.out.println("Exception in ManagerLoginDashboard" + e);
      }

  }
}
