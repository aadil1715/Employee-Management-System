package com.dalhousie.group14.Presentation.employee;

import com.dalhousie.group14.Database.employee.insert_resign_requests;
import com.dalhousie.group14.Database.employee.get_employee_id;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class make_resign_request {

  public static void main(String[] args) {
    make_resign_request obj = new make_resign_request();
    obj.resign_request();
  }

  public void resign_request() {
    get_employee_id gi = new get_employee_id();
    insert_resign_requests irr = new insert_resign_requests();
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter your username");
    String username = scanner.nextLine();
    gi.get_EmployeeID(username);
    System.out.println("Your ResignDate in yyyy/MM/dd format is:");
    LocalDate localDate = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    System.out.println(localDate);
    System.out.println("Enter the reason for resignation");
    String reason = scanner.next();
    irr.insert_resign_request_details(gi.get_EmployeeID(username), localDate, reason);

  }

}
