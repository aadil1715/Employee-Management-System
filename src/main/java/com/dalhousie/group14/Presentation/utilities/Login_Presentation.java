package com.dalhousie.group14.Presentation.utilities;

import java.util.Scanner;

public class Login_Presentation {

    public void login() {
        System.out.println("................WELCOME TO LOGIN PAGE...............");
        Scanner scanner = new Scanner(System.in);
        int select;
        try {
            do {
                System.out.println("Press 1 for Employee Login: \n Press 2 for Manager Login: \n Press 3 for Client Login:");
                select = scanner.nextInt();
                if (select == 1) {
                    loginEmployee();
                } else if (select == 2) {
                    //loginManager();
                } else if (select == 3) {
                    //loginClient();
                } else {
                    System.out.println("Please Enter correct number:");
                }
            } while (true);
        } catch (Exception e) {
            System.out.println("Exception:"+e);
        }
    }
}
