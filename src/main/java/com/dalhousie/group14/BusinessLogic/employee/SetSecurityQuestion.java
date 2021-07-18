package com.dalhousie.group14.BusinessLogic.employee;

import com.dalhousie.group14.Database.employee.DBSecurityQuestion;

import java.util.ArrayList;
import java.util.Scanner;

/* Author- Jainam Shah(B00883898)
 * SetSecurityQuestion java class contains three task. One is to ask Security
 * from employee and insert data into database. Second is to ask the answers
 * of this question. And 3rd one is to insert Security Question and Answer in
 *  database.
 */
public class SetSecurityQuestion implements ISetSecurityQuestion {

  /**
   * This method take userName as as parameter and insert Security Question
   * Answer into database.
   *
   * @param userName
   */
  @Override
  public void setSecurityQuestion(String userName) {

    String question1;
    String question2;
    String question3;
    String answer1;
    String answer2;
    String answer3;

    /*Create Object of DBSecurityQuestion*/
    DBSecurityQuestion dbSecurityQuestion = new DBSecurityQuestion();

    Scanner scanner = new Scanner(System.in);
    String userId = userName;
    ArrayList<String> arrayList;

    /* take userName and insert Security Question in the with userName and
    questions in the database.
     */
    dbSecurityQuestion.setSecurityQuestionFirstTime(userId);

    /*All security Question Answer stored in arrayList ans we can access it.*/
    arrayList = dbSecurityQuestion.getSecurityQuestion(userId);

    userId = arrayList.get(0);
    System.out.println("Username:" + userId);
    System.out.println("Please Write the answer of questions:");

    question1 = arrayList.get(1);
    System.out.println(question1);
    answer1 = scanner.nextLine();

    question2 = arrayList.get(2);
    System.out.println(question2);
    answer2 = scanner.nextLine();

    question3 = arrayList.get(3);
    System.out.println(question3);
    answer3 = scanner.nextLine();

    /*Insert security Question Answer into database.*/
    dbSecurityQuestion.insertSecurityAnswer(userId, answer1, answer2,
        answer3);
  }
}