package com.dalhousie.group14.Presentation.manager;

import com.dalhousie.group14.BusinessLogic.manager.Manager;
import com.dalhousie.group14.Presentation.utilities.Login;

import java.util.Scanner;

/**
 * This is Manager Login Dashboard. After successfully login manager redirect
 * to this page. Manager has option to select.
 */
public class ManagerLoginDashBoard {

  public static void main(String[] args) {
    ManagerLoginDashBoard obj = new ManagerLoginDashBoard();
    obj.managerLoginDashBoard();
  }
  public void managerLoginDashBoard() {

    Scanner scanner = new Scanner(System.in);
    ManageEmployee ManageEmployee = new ManageEmployee();
    IRequestForApprovals request = new RequestForApprovals();

    System.out.println("\t\t\t\t\t\t\t\t\t\t\t\tWelcome to Manager Dashboard\t\t\t\t\t\t\t\t\t\t\t\t");

    System.out.println("Please Select the number from following Options:");


    int select;
    boolean decision = true;
    do {
      try {
        System.out.println("Enter from the following options. Enter Numerical" +
            " Input Only.");
        System.out.println("1. Employee Profile Management. \n2. Project " +
            "Management. \n3. Employee Performance Evaluation. \n4. Request " +
            "Management \n5. Employee Schedule Management \n6. Employee " +
            "Salary" +
            " Management. \n7. Notifications \n8. Logout \n9. Exit from the " +
            "application.");
        select = scanner.nextInt();
        switch (select) {
          case 1:
            ManageEmployee.manageEmployee();
            System.out.println("Manage Employee");
            break;
          case 2:
            IProjectManagementDashboard obj = new ProjectManagementDashboard();
            obj.projDashboard();
            break;
          case 3:
            PerformanceEvaluatorScreen obj2 = new PerformanceEvaluatorScreen();
            obj2.evaluatoroptions();
            break;
          case 4:
            request.requestForApprovals();
            System.out.println("Requests");
            break;
          case 5:
            DisplayEmployeeSchedule obj3 = new DisplayEmployeeSchedule();
            obj3.displayScreen();
            break;
          case 6:
            SalaryOfEmployee se=new SalaryOfEmployee();
            se.ViewAllEmployees();
            break;
          case 7:

            break;
          case 8:
            System.out.println("Logging out from the Manager Portal.");
            Login login = new Login();
            login.userType();
            break;
          case 9:
            decision = false;
            return;
          default:
            System.out.println("Enter Correct number:");
        }
      } catch (Exception e) {
        System.out.println("Exception in ManagerLoginDashboard" + e);
      }
    } while (decision);
  }
}
