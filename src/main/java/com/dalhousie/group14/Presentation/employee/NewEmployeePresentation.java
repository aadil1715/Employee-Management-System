package com.dalhousie.group14.Presentation.employee;



import com.dalhousie.group14.BusinessLogic.employee.NewEmployeeBusiness;

import java.util.Scanner;

/*
* Author:-Ninad Nitin Shukla
* FileName:-NewEmployee
* Display of new employee
*
* */
public class NewEmployeePresentation {
  /*This page displays the login screen for new employee*/
  void newEmployeeLogin(){
    boolean exit=false;
    do {
      System.out.println("Hello welcome to xyz company.Please add your " +
              "temporary UserName and Password so that you can request for " +
              "permanent credentials");
      Scanner sc = new Scanner(System.in);

      String userName = sc.nextLine();
      String password = sc.nextLine();
      NewEmployeeBusiness nb = new NewEmployeeBusiness();
      nb.Login(userName, password);
    }while (exit==false);

  }

  void applyRequest(){
    System.out.println("Please Enter your new permanent username.(Username " +
            "should be greater than 4 characters please avoid any spaces or " +
            "any special characters)");
    Scanner scanner=new Scanner(System.in);
    String userName=scanner.nextLine();

  }

}
