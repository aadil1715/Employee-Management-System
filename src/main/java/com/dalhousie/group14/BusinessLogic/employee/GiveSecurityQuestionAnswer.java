package com.dalhousie.group14.BusinessLogic.employee;

import com.dalhousie.group14.Database.employee.DBSecurityQuestion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

/**
 * This class take all question form database and logically select one out
 * of three and ask to employee to give answer if answer is correct then
 * allow to redirect Login Dashboard Page.
 */
public class GiveSecurityQuestionAnswer implements IGiveSecurityQuestionAnswer {

  @Override
  /*
   * This method take all question form database and logically select one out
   * of three and ask to employee to give answer if answer is correct then
   * allow to redirect Login Dashboard Page.
   */
  public void giveSecurityQuestionAnswer(String username) {

    DBSecurityQuestion dbSecurityQuestion = new DBSecurityQuestion();

    int max = 3;
    int min = 1;
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);
    HashMap<Integer, String> hashMap = new HashMap<>();
    ArrayList<String> arrayList;
    String question1, question2, question3;

    /* Get all security from database. */
    arrayList = dbSecurityQuestion.getSecurityQuestion(getUsername(username));

    question1 = arrayList.get(1);
    System.out.println("Question 1:" + question1);
    question2 = arrayList.get(2);
    System.out.println("Question 2:" + question2);
    question3 = arrayList.get(3);
    System.out.println("Question 3:" + question3);

    hashMap.put(1, getUsername(question1));
    hashMap.put(2, getUsername(question2));
    hashMap.put(3, getUsername(question3));
    System.out.println(hashMap);

    /* Generate Random Number */
    int randomNum = random.nextInt((max - min) + 1) + min;
    System.out.println(randomNum);

    String question = hashMap.get(randomNum);
    System.out.println("Your Question is:" + getUsername(question));

    System.out.println("Please Write the answer:");
    String answer = scanner.nextLine();

    /*Check Employee is validate or not.*/
    dbSecurityQuestion.employeeValidate(getUsername(username),
        getUsername(answer));
  }

  private static String getUsername(String username) {

    return username;
  }
}
