package com.dalhousie.group14.Presentation.client;
import com.dalhousie.group14.BusinessLogic.client.ClientDashboardValidation;
import java.util.Scanner;

public class ClientDashboard {
    private void clientscreen() {
        ClientDashboardValidation clientDashboardValidation = new ClientDashboardValidation();
        Project project  = new Project();
        boolean correctoption = false;
        int optionchosen = 0;
        System.out.println();
        System.out.println("Enter from the following options");
        System.out.println("1. Define a project.");
        System.out.println("2. Check the project status.");
        System.out.println("3. Provide project feedback.");
        System.out.print("Provide your input here : ");

        for (int i = 0; i < 3; i++) {
            try {
                Scanner s = new Scanner(System.in);
                optionchosen = s.nextInt();
                correctoption = clientDashboardValidation.clientinput(optionchosen);
            } catch (Exception e) {
                if (i < 2) {
                    System.out.print("Incorrect Input, Enter your input again : ");
                } else {
                    System.out.println("You have used all your attempts, log back into the application.");
                }
            }
        }
        if(correctoption){
            if(optionchosen == 1 ){
                project.defineproject();
            }else{
                if(optionchosen == 2 ){
                }
            }
        }
    }

}
