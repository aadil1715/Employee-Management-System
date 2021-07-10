package com.dalhousie.group14.Presentation.employee;



import java.util.Scanner;

import static com.dalhousie.group14.BusinessLogic.employee.GiveSecurityQuestionAnswer.giveSecurityQuestionAnswer;
import static com.dalhousie.group14.BusinessLogic.employee.SetSecurityQuestion.setSecurityQuestion;

public class SecurityQuestion {
    public static void securityQuestion(String userid) {
        String username;
        username = userid;
        Scanner scanner = new Scanner(System.in);
        int select;

        System.out.println("Your UserName is:" + username);
        System.out.println("Press 1 for create Security Question Answer (For First time User): \n" +
                            "Press 2 for give the answer of security question.");
        try {
            //noinspection InfiniteLoopStatement
            do {
                select = scanner.nextInt();
                if (select == 1) {
                    setSecurityQuestion(username);
                } else if (select == 2) {
                    giveSecurityQuestionAnswer(username);
                } else {
                    System.out.println("Please Enter Right Choice:");
                }
            } while (true);
        } catch (Exception e) {
            System.out.println("Exception:"+e);
        }
    }
}
