package com.dalhousie.group14.Database.employee;

import java.sql.Date;
import java.util.HashMap;

public interface IDBRequestForLeave {

  void insertRequestForLeave(int employeeID, int managerID, Date actualstartingLeaveDate,
                             Date actualendingLeaveDate, long days, int remainingleaves,
                             String reason, String status);

  int remainingLeaves(int userID);

  HashMap<Integer, HashMap<String, String>> getAllLeaveInfo();

  void updateLeaveRequest(String username, String status, String days, int RemainingLeaves);

  void cancelLeaveRequest(String username, String status);
}
