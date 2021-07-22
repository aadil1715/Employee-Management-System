package com.dalhousie.group14.Presentation.client;
import com.dalhousie.group14.BusinessLogic.client.ClientDashboardValidation;

import java.util.Scanner;

public class ClientDashboard implements NormalClient {
  int low_range = 0;
  int high_range = 4;
  public static final int maxtries = 3;

  public void clientscreen() {
    ClientDashboardValidation clientDashboardValidation = new ClientDashboardValidation();
    ClientProject project  = new ClientProject();
    boolean correctoption = false;
    int optionchosen = 0;
    System.out.println();
    System.out.println("Enter from the following options");
    System.out.println("1. Define a project.");
    System.out.println("2. Check the project status.");
    System.out.println("3. Provide project feedback.");
    System.out.print("Provide your input here : ");

    for (int i = 0; i < maxtries; i++) {
      try {
        Scanner s = new Scanner(System.in);
        optionchosen = s.nextInt();
        correctoption = clientDashboardValidation.clientInput(optionchosen, low_range, high_range);
        if(correctoption){
          break;
        }
      } catch (Exception e) {
        System.out.print("Incorrect Input, Enter your input again : ");
      }
    }
    if(!correctoption){
      System.out.println("You have used all your attempts, log back into the application.");
    }
    if(correctoption){
      if(optionchosen == 1 ){
        boolean response =  project.defineproject();
        if(response){
          System.out.println("Your project has been successfully defined along with its milestones.");
        }else{
          System.out.println("The project was not defined due to illegal operations.");
        }
      }else{
        if(optionchosen == 2 ){
        }
      }
    }
  }

}
