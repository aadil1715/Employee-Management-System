package com.dalhousie.group14.BusinessLogic.employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

import static com.dalhousie.group14.Database.employee.EmployeeValidate.employeeValidate;
import static com.dalhousie.group14.Database.employee.GetSecurityQuestion.getSecurityQuestion;

interface  GiveSecurityQuestionAnswers{
    int max = 3;
    int min = 1;
    Random random = new Random();
}
public class GiveSecurityQuestionAnswer implements GiveSecurityQuestionAnswers{
    
    public static void giveSecurityQuestionAnswer(String username) {


        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, String> hashMap = new HashMap<>();
        ArrayList<String> arrayList;
        String question1,question2,question3;

        arrayList=getSecurityQuestion(getUsername(username));
        question1=arrayList.get(0);
        question2= arrayList.get(1);
        question3= arrayList.get(2);

        hashMap.put(1, getUsername(question1));
        hashMap.put(2, getUsername(question2));
        hashMap.put(3, getUsername(question3));
        System.out.println(hashMap);

        int randomNum = random.nextInt((max - min) + 1) + min;
        System.out.println(randomNum);

        String s= hashMap.get(randomNum);
        System.out.println(""+ getUsername(s));

        String answer = scanner.nextLine();
        System.out.println("answer:"+ getUsername(answer));

        employeeValidate(getUsername(username), getUsername(answer));
    }

    private static String getUsername(String username) {
        return username;
    }
}
