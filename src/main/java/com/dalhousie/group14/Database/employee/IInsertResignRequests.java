package com.dalhousie.group14.Database.employee;

import java.time.LocalDate;

public interface IInsertResignRequests {

  void insertResignRequestDetails(int id, LocalDate date, String reason);

}
