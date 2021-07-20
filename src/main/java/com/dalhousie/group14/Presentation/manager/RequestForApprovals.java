package com.dalhousie.group14.Presentation.manager;

import java.util.Scanner;

/**This class handle the all requests.
 */
public class RequestForApprovals implements IRequestForApprovals {

  @Override
  public void requestForApprovals() {

    Scanner scanner = new Scanner(System.in);
    RequestLeave requestLeave = new RequestLeave();

    ManagerLoginDashBoard managerLoginDashBoard =
        new ManagerLoginDashBoard();

    System.out.println("Welcome... You can approve or reject following " +
        "requests.");

    System.out.println("Select 1 for Joining Requests\nSelect 2 for Leave " +
        "Request\nSelect 3 for Resign Request\nSelect 4 for Asset " +
        "Request\nSelect 5 for Mediclaim Request\nSelect 6 for goto Previous " +
        "Page.");

    int select;
    select = scanner.nextInt();
    switch (select) {
      case 1:
        System.out.println("Redirect to Joining Request Page.");
        break;
      case 2:
        requestLeave.requestLeave();
        System.out.println("Request for leave");
        break;
      case 3:
        System.out.println("Redirect to Resign Request Page.");
        break;
      case 4:
        System.out.println("Redirect to Asset Request Page.");
        break;
      case 5:
        System.out.println("Redirect to Mediclaim Request Page.");
        break;
      case 6:
       // managerLoginDashBoard.managerLoginDashBoard();
        System.out.println("");
      default:
        System.out.println("Enter valid number:");
    }
  }
}