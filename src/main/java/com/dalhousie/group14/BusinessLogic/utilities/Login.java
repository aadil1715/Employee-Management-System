package com.dalhousie.group14.BusinessLogic.utilities;
import java.util.Scanner;
import static com.dalhousie.group14.Presentation.employee.SecurityQuestion.securityQuestion;


//
//interface login{
//    static abstract void loginEmployee();
//    void loginManager();
//    void loginClient();
//
//}

public class Login {
    private static String username;
    static Scanner scanner;
    private static String password;


    public static void loginEmployee() {
        System.out.println("Enter Your Userid for Login:");
        username= scanner.next();
        System.out.println("Enter your Password for Login:");
        password= scanner.next();
        System.out.println("Check Credentials:::");
        System.out.println("If yes:");
        securityQuestion(username);
    }

  //  @Override
    public void loginManager() {
        username= scanner.next();
        password= scanner.next();
    }

//    @Override
    public void loginClient() {
        username= scanner.next();
        password= scanner.next();
    }
}
