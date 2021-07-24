package com.dalhousie.group14.Presentation.employee;

import com.dalhousie.group14.BusinessLogic.employee.ValidateResignRequestEmployee;
import com.dalhousie.group14.Database.employee.GetEmployeeID;
import com.dalhousie.group14.Database.employee.InsertResignRequests;

import java.util.Scanner;

public interface IResignRequest {

  Scanner scanner = new Scanner(System.in);

  Scanner scanner1 = new Scanner(System.in);

  GetEmployeeID gi = new GetEmployeeID();

  InsertResignRequests irr = new InsertResignRequests();

  ValidateResignRequestEmployee validate = new ValidateResignRequestEmployee();

}
