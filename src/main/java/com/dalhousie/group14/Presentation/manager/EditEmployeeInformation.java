package com.dalhousie.group14.Presentation.manager;

import com.dalhousie.group14.Database.manager.DBEditEmployeeInformation;
import com.dalhousie.group14.Database.manager.EmployeeBean;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

import static java.sql.Date.valueOf;

/**
 * This class edit the employee information.
 */

public class EditEmployeeInformation {

  public void editEmployeeInformation() {

    DBEditEmployeeInformation dbEditEmployeeInformation =
        new DBEditEmployeeInformation();

    Scanner scanner = new Scanner(System.in);
    Scanner scannerString = new Scanner(System.in);

    int select;
    int employeeID;
    String contactName;
    String gender;
    String birthDate;
    Date DOB;

    ArrayList<EmployeeBean> arrayList =
        dbEditEmployeeInformation.getAllEmployeeInformation();

    System.out.println("EmployeeID" + " " + "UserName" + " " + "ContactName" + " "
        + "gender" + " " + "DOB" + " " + "Basicsalary" + " " + "CTC" + " " + "bonus" + " " + "lastmonthsalary" + " " + "EPF");

    /* This loop display all information of available employee.*/
    for (EmployeeBean employeeBean : arrayList) {
      System.out.print(employeeBean.getEmployeeID() + "  " + employeeBean.getUserName() + "  " +
          employeeBean.getContactName() + "  " + employeeBean.getGender() + "  " + employeeBean.getDOB() + "  " +
          employeeBean.getBasicsalary() + "  " + employeeBean.getCTC() + "  " +
          employeeBean.getBonus() + "  " + employeeBean.getLastmonthsalary() + "  " + employeeBean.getEPF());
      System.out.println();
    }

    System.out.println("Enter UserID of the employee that you want to edit.");
    employeeID = scanner.nextInt();

    EmployeeBean employeeBean =
        dbEditEmployeeInformation.getAllEmployeeByID(employeeID);

    System.out.println("Employee`s ID:" + employeeID);

    System.out.println("Select 1 to change the Contact Name\nSelect 2 to " +
        "change the Gender\nSelect 3 to change the Date Of Birth");

    select = scanner.nextInt();

    switch (select) {
      case 1:
        System.out.println("Enter Contact Name for edit.");
        contactName = scannerString.nextLine();
        employeeBean.setContactName(contactName);
        dbEditEmployeeInformation.employeeUpdate(employeeBean);
        break;
      case 2:
        System.out.println("Enter Gender for update");
        gender = scannerString.nextLine();
        employeeBean.setGender(gender);
        dbEditEmployeeInformation.employeeUpdate(employeeBean);
        break;
      case 3:
        System.out.println("Enter DOB for the update:");
        birthDate = scannerString.nextLine();
        DOB = valueOf(birthDate);
        employeeBean.setDOB(DOB);
        dbEditEmployeeInformation.employeeUpdate(employeeBean);
        break;
      default:
        System.out.println("Enter valid number:");
    }

  }
}
