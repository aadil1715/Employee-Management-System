package com.dalhousie.group14.Presentation.employee;

import java.util.Scanner;

public class ProjectManagement {
  public void display(){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Project Management for Employee");
    System.out.println("Select one of the following operations: ");
    System.out.println("1. See Milestone Deadline.");
    System.out.println("2. Complete Milestone.");
    System.out.println("3. Project History.");
    ProjectManagement projectManagement = new ProjectManagement();
    int choice = scanner.nextInt();
    switch (choice){
      case 1:
          DisplayMilestone displayMilestone = new DisplayMilestone();
          displayMilestone.display();
          System.out.println("Press \"ENTER\" to continue...");
          scanner = new Scanner(System.in);
          scanner.nextLine();
          projectManagement.display();
      case 2:
          CompleteMilestone completeMilestone = new CompleteMilestone();
          completeMilestone.display();
          System.out.println("Press \"ENTER\" to continue...");
          scanner = new Scanner(System.in);
          scanner.nextLine();
          projectManagement.display();
      case 3:
          DisplayProject displayProject = new DisplayProject();
          displayProject.display();
          System.out.println("Press \"ENTER\" to continue...");
          scanner = new Scanner(System.in);
          scanner.nextLine();
          projectManagement.display();
      default:
        System.out.println("Please enter a correct option.");
        display();
    }
  }

  public static void main(String[] args) {
   ProjectManagement projectManagement = new ProjectManagement();
   projectManagement.display();
  }
}
