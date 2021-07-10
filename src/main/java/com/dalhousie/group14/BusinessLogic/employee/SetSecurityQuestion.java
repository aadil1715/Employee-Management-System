package com.dalhousie.group14.BusinessLogic.employee;

import java.util.ArrayList;
import java.util.Scanner;
import com.dalhousie.group14.Database.utilities.DbConnection;
import static com.dalhousie.group14.Database.employee.GetSecurityQuestion.getSecurityQuestion;
import static com.dalhousie.group14.Database.employee.InsertSecurityAnswer.insertSecurityAnswer;
import static com.dalhousie.group14.Database.employee.SetSecurityQuestionFirstTime.setSecurityQuestionFirstTime;


public class SetSecurityQuestion {

    public static void setSecurityQuestion(String username) {
        String question1, question2,
                question3, answer1, answer2, answer3;

        String userid = username;
        ArrayList<String> arrayList;
        Scanner scanner = new Scanner(System.in);

        setSecurityQuestionFirstTime(userid);
        arrayList = getSecurityQuestion(userid);

        userid = arrayList.get(0);
        System.out.println("Username:" + userid);
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

        insertSecurityAnswer(userid, answer1, answer2, answer3);

    }
}
