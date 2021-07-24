package com.dalhousie.group14.Presentation.employee;

import java.time.LocalDate;

public class MakeResignRequest implements IResignRequest {

  public static int count = 0;

  public static void main(String[] args) {
    MakeResignRequest obj = new MakeResignRequest();
    obj.resignRequest();
  }

  public void resignRequest() {
    try {
      System.out.println("Enter your username");
      String username = scanner.nextLine();
      if (validate.validateName(username) == false) {
//        count++;
        System.out.println("Username entered is invalid. Please try again.");
//        if (count < 3) {
        resignRequest();
//        }
//        if (count == 3) {
//          System.out.println("You have reached the maximum number of attempts" +
//              ".Please try again later.");
//          System.exit(-1);
//        }
      } else if (validate.validateName(username) == true) {
        System.out.println("username is valid");
      }

      gi.get_EmployeeID(username);
      System.out.println("Your ResignDate in yyyy/MM/dd format is:");
      LocalDate localDate = LocalDate.now();
      System.out.println(localDate);
      System.out.println("Enter the reason for resignation");
      String reason = scanner1.nextLine();
      if (!validate.validateReason(reason)) {
        System.out.println("Reason entered is not in proper format. Please try again later.");
      } else {
        System.out.println("You have successfully created the Resign Request.");
        irr.insertResignRequestDetails(gi.get_EmployeeID(username), localDate, reason);
      }
    } catch (Exception exception) {
      System.out.println(exception);
    }
  }

}
