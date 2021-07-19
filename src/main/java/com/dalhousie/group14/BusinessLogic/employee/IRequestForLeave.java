package com.dalhousie.group14.BusinessLogic.employee;

public interface IRequestForLeave {

  /* Take data from employee like name, when want to leave start and end data
   * logically calculated the date difference between this. Take all data
   * process it if needed then send to the database Layer.
   */

  void requestForLeave();

  boolean dateValidation(String actualStartingLeaveDate,
                         String actualEndingLeaveDate);

}
