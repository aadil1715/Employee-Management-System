package com.dalhousie.group14.Presentation.manager;

import java.util.Scanner;

public class Approve_Requests {
    public void select_option()
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Select any of the following tasks that you might want to perform :"+ "" +
                "\n1. Joining Requests \n2. Leave Requests \n3. Resign Requests \n4. Asset Request \n5. Mediclaim Requests \n6. Go back to the previous page ");
        int option=scanner.nextInt();
        switch (option){
            case 1:
                System.out.println("You selected joining requests");
                break;
            case 2:
                System.out.println("You selected leave requests");
                break;
            case 3:
                System.out.println("You selected resign requests");

                break;
            case 4:
                System.out.println("You selected asset requests");
                break;
            case 5:
                System.out.println("You selected mediclaim requests");
                break;
            case 6:
                System.out.println("You selected go back to the previous page");
                break;
        }
    }
}
