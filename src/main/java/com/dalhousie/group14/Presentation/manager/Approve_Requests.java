package com.dalhousie.group14.Presentation.manager;

import java.util.Scanner;
import com.dalhousie.group14.Database.manager.approved_status;
import com.dalhousie.group14.BusinessLogic.employee.notice_period;

public class Approve_Requests {

  public static void main(String[] args) {
    Approve_Requests ar = new Approve_Requests();
    ar.select_option();
  }

  public void select_option() {
    resign_requests1 rr1 = new resign_requests1();
    leave_requests lr = new leave_requests();
    mediclaim_requests mr= new mediclaim_requests();
    asset_requests ar = new asset_requests();
    Scanner scanner = new Scanner(System.in);
    System.out.println("Select any of the following tasks that you might want to perform :" + "" +
            "\n1. Joining Requests \n2. Leave Requests \n3. Resign Requests \n4. Asset Requests \n5. Mediclaim Requests \n6. Go back to the previous page ");
    int option = scanner.nextInt();
    switch (option) {
      case 1:
        System.out.println("You selected joining requests");
        break;
      case 2:
        System.out.println("You selected leave requests");
        lr.display_leave_requests();
        break;
      case 3:
        System.out.println("You selected resign requests");
        rr1.display_resign_requests();
        break;
      case 4:
        System.out.println("You selected asset requests");
        ar.display_asset_requests();
        break;
      case 5:
        System.out.println("You selected mediclaim requests");
        mr.display_mediclaim_requests();
        break;
      case 6:
        System.out.println("You selected go back to the previous page");
        break;
    }

  }

}
