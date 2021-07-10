package com.dalhousie.group14.BusinessLogic.employee;

import java.util.Scanner;

import static com.dalhousie.group14.Database.employee.UpdateSecurityAnswer.updateSecurityAnswer;
import static com.dalhousie.group14.Database.employee.UpdateSecurityQuestion.updateSecurityQuestion;

public class ChangeSecurityQuestion {

    public static void changeSecurityQuestion() {
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

        updateSecurityQuestion(username, question1, question2, question3);
        updateSecurityAnswer(username, answer1, answer2, answer3);

    }
}
