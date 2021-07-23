package com.dalhousie.group14.Presentation.employee;

import com.dalhousie.group14.BusinessLogic.employee.Validation;
import com.dalhousie.group14.Database.employee.DatabaseMediclaimRequests;

import java.util.Scanner;

public interface IMediclaimRequest {
 Scanner scanner=new Scanner(System.in);
 Validation validation=new Validation();
 DatabaseMediclaimRequests obj=new DatabaseMediclaimRequests();
}
