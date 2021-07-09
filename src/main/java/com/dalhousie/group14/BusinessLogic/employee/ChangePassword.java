package com.dalhousie.group14.BusinessLogic.employee;

import java.util.Scanner;

import static com.dalhousie.group14.Database.employee.DisplayEmployeeLoginInfo.displayEmployeeLoginInfo;
import static com.dalhousie.group14.Database.employee.UpdatePassword.updatePassword;

public class ChangePassword {

    public static void changePassword(){
            String username,password;
            Scanner scanner= new Scanner(System.in);

            System.out.println("Enter your UserName");
            username= scanner.nextLine();

            System.out.println("Enter your New Password");
            password= scanner.nextLine();

            updatePassword(username,password);
            displayEmployeeLoginInfo(username);
        }
    }

