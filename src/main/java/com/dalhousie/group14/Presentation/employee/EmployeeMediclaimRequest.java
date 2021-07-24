package com.dalhousie.group14.Presentation.employee;

public class EmployeeMediclaimRequest implements IMediclaimRequest {

  static String name;
  static int policynumber;
  static int amount;
  static String reason;
  static String status = "pending";

  public static void main(String[] args) {
    EmployeeMediclaimRequest emr = new EmployeeMediclaimRequest();
    emr.callALlMethods();

  }

  public void callALlMethods() {
    enterName();
    enterPolicyNumber();
    moneyClaimed();
    giveReason();
    obj.employeeMediclaimRequests(name, policynumber, amount, reason, status);
  }

  public void enterName() {

    System.out.println("Enter your Name");
    name = scanner.nextLine();
    if (validation.validateName(name)) {
      System.out.println("name is valid");
    } else {
      System.out.println("name entered cannot be null or empty or should not contain special characters or numbers");
      enterName();
    }
  }

  public void enterPolicyNumber() {
    System.out.println("Enter your policy number");
    policynumber = scanner.nextInt();
    if (validation.validatePolicyNumber(policynumber)) {
      System.out.println("the policynumber is valid");
    } else {
      System.out.println("policy number cannot be negative or zero");
      enterPolicyNumber();
    }
  }

  public void moneyClaimed() {
    System.out.println("Enter the amount you want to claim");
    amount = scanner.nextInt();
    if (validation.validateMoneyClaimed(amount)) {
      System.out.println("the amount is valid");
    } else {
      System.out.println("The claimed amount cannot be negative or zero");
      moneyClaimed();
    }

  }

  public void giveReason() {

    System.out.println("Enter your valid reason for mediclaim");
    reason = scanner.next();
    if (validation.validateReason(reason)) {
      System.out.println("You have entered valid input");
      System.out.println("You have successfully made the mediclaim request.");
    } else {
      System.out.println("The reason should be of string type ");
      giveReason();

    }

  }

}
