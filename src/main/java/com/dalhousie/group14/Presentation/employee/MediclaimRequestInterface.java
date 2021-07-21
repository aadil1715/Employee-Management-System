package com.dalhousie.group14.Presentation.employee;

import com.dalhousie.group14.BusinessLogic.employee.Validation;
import com.dalhousie.group14.Database.employee.Database_Mediclaim_Requests;

import java.util.Scanner;

public interface MediclaimRequestInterface {
 Scanner scanner=new Scanner(System.in);
 Validation validation=new Validation();
 Database_Mediclaim_Requests obj=new Database_Mediclaim_Requests();
}
