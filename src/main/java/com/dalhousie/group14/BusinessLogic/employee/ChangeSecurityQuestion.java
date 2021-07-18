package com.dalhousie.group14.BusinessLogic.employee;

import com.dalhousie.group14.Database.employee.DBSecurityQuestion;

import java.util.Scanner;

public class ChangeSecurityQuestion implements IChangeSecurityQuestion {

  @Override
  public void changeSecurityQuestion() {

    DBSecurityQuestion dbSecurityQuestion = new DBSecurityQuestion();
    String username;
    String question1, answer1;
    String question2, answer2;
    String question3, answer3;

    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter UserName:");

    username = scanner.nextLine();
    System.out.println("Enter Security Question 1:");
    question1 = scanner.nextLine();
    System.out.println("Enter Answer for Security Question 1:");
    answer1 = scanner.nextLine();

    System.out.println("Enter Security Question 2:");
    question2 = scanner.nextLine();
    System.out.println("Enter Answer for Security Question 2:");
    answer2 = scanner.nextLine();

    System.out.println("Enter Security Question 3:");
    question3 = scanner.nextLine();
    System.out.println("Enter Answer for Security Question 3:");
    answer3 = scanner.nextLine();

    dbSecurityQuestion.updateSecurityQuestion(username, question1, question2, question3);
    dbSecurityQuestion.updateSecurityAnswer(username, answer1, answer2, answer3);


  }
}
