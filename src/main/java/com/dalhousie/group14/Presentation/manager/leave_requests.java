package com.dalhousie.group14.Presentation.manager;

import com.dalhousie.group14.Database.manager.database_leave_requests;

public class leave_requests implements leave_requests_interface {

  public void display_leave_requests() {
    database_leave_requests lr = new database_leave_requests();
    System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t-----List of Leave Requests-----\t\t\t\t\t\t\t\t\t\t\t\t");
    System.out.printf("%10s %15s %30s %35s %30s %30s %30s %30s %30s", "EMPLOYEE ID", "MANAGER ID", "REQUEST ID", "FROM DATE", "TO DATE", "DAYS", "REMAINING LEAVES", "REASON", "APPROVED STATUS\n");
    lr.select_leave_requests();
  }

}
