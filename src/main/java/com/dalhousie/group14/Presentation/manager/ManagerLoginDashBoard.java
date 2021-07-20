package com.dalhousie.group14.Presentation.manager;

import java.util.Scanner;

/**This is Manager Login Dashboard. After successfully login manager redirect
 *  to this page. Manager has option to select.
 */
public class ManagerLoginDashBoard {

  public void managerLoginDashBoard(){
    Scanner scanner = new Scanner(System.in);

    ManageEmployee ManageEmployee =new ManageEmployee();

    IRequestForApprovals request=new RequestForApprovals();

    System.out.println("Welcome to Manager Dashboard..");

    System.out.println("Please Select the number from following Options:");

    System.out.println("Select 1 for ManageEmployee:\nSelect 2 for Approve " +
        "Requests:\nSelect 3 for Project Management:\nSelect 4 for LogOut:");
    int select;
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
        System.out.println("Project Management");
        break;
      case 4:
        System.out.println("Logout");
        break;
      default:
        System.out.println("Enter Correct number:");
    }
  }
}
