package com.dalhousie.group14.Presentation.employee;

import com.dalhousie.group14.Database.employee.MilestoneOperations;
import com.dalhousie.group14.Database.employee.ProjectOperations;

import java.util.List;
import java.util.Scanner;

public class DisplayProject {
  public void display(){
    System.out.println("Project Deadlines: ");
    System.out.println();
    String empID = "2";
    List<String> milestoneInfo;
    ProjectOperations projectOperations = new ProjectOperations();
    milestoneInfo = projectOperations.getProjects(empID);
    for(int i=0;i<milestoneInfo.size()/6;i++){
      System.out.print("\nProject " + (i+1));
      System.out.print("\nProject ID: ");
      System.out.print(milestoneInfo.get(0 + (i*6)));
      System.out.print("\nProject Name: ");
      System.out.print(milestoneInfo.get(1 + (i*6)));
      System.out.print("\nProject Languages: ");
      System.out.print(milestoneInfo.get(2 + (i*6)));
      System.out.print("\nProject Start Date: ");
      System.out.print(milestoneInfo.get(3 + (i*6)));
      System.out.print("\nProject End Date: ");
      System.out.print(milestoneInfo.get(4 + (i*6)));
      System.out.print("\nProject Status: ");
      System.out.print(milestoneInfo.get(5 + (i*6)));
      System.out.println();
    }
  }
}
