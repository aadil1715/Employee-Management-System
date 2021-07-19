package com.dalhousie.group14.Presentation.manager;

import java.util.Scanner;

public class ManagerLoginDashBoard {

  public void managerLoginDashBoard(){
    Scanner scanner = new Scanner(System.in);
    ManageEmployee manageEmployee=new ManageEmployee();
    System.out.println("Welcome to Manager Dashboard.. Mr Ninad Sukla");

    System.out.println("Please Select the number from following Options:");

    System.out.println("Select 1 for ManageEmployee:\nSelect 2 for Approve " +
        "Requests:\nSelect 3 for Project Management:\nSelect 4 for LogOut:");
    int select;
    select = scanner.nextInt();
    switch (select) {
      case 1:
        manageEmployee.manageEmployee();
        System.out.println("ManageEmployee");
        break;
      case 2:
        System.out.println("Requests");
        break;
      case 3:
        System.out.println("Project Management");
        break;
      case 4:
        System.out.println("Logout");
        break;
    }
  }
}
