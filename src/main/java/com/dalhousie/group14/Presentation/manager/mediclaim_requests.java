package com.dalhousie.group14.Presentation.manager;


import java.util.Scanner;

/* Name of File: mediclaim_requests.java
   Author: Ria Shah
   Class Description: This class will display the list of all the mediclaim requests to the manager on his
   manager dashboard such object1 Name, Policy Number,Medical ID, Remaining Money, Money Claimed,Reason columns
   Method name/s: display_mediclaim_requests
 */

public class mediclaim_requests implements mediclaimRequestInterface {

  public void display_mediclaim_requests() {
    System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t-----LIST OF MEDICLAIM REQUESTS-----\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
    System.out.printf("%10s %15s %30s %30s %30s %30s", "NAME", "POLICY NUMBER", "MEDICAL ID", "MONEY CLAIMED", "REASON", "APPROVED STATUS\n");
    object1.display_mediclaim_requests();
    System.out.println("Do you want to approve or reject the pending requests?\nType Y for yes or N for no");
    Scanner scanner = new Scanner(System.in);
    String input = scanner.next();

    if (input.equalsIgnoreCase("Y")) {
      Scanner scanner1 = new Scanner(System.in);
      System.out.println("Enter the name of employee you want to approve the request");
      String name = scanner1.nextLine();
      object4.validateNameRequestApproval(name);

    } else if (input.equalsIgnoreCase("N")) {
      Scanner scanner1 = new Scanner(System.in);
      System.out.println("Enter the name of employee you want to reject the request");
      String name = scanner1.nextLine();
      object4.validateNameRequestRejection(name);
    } else {
      object4.validateInput(input);
      display_mediclaim_requests();
    }
  }

}


