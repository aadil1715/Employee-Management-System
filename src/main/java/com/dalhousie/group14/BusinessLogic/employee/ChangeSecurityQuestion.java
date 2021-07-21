package com.dalhousie.group14.BusinessLogic.employee;

import com.dalhousie.group14.Database.employee.DBSecurityQuestion;

import java.util.Scanner;

/* Author- Jainam Shah(B00883898)
 * This class implement the IChangeSecurityQuestion interface.
 * This class employee can change the security question and answer.
 */
public class ChangeSecurityQuestion implements IChangeSecurityQuestion {

  @Override
  public void changeSecurityQuestion() {

    DBSecurityQuestion dbSecurityQuestion = new DBSecurityQuestion();
    String userName;
    String question1;
    String answer1;
    String question2;
    String answer2;
    String question3;
    String answer3;

    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter UserName:");

    userName = scanner.nextLine();
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

    dbSecurityQuestion.updateSecurityQuestion(userName, question1, question2, question3);
    dbSecurityQuestion.updateSecurityAnswer(userName, answer1, answer2, answer3);

  }
}
