package com.dalhousie.group14.Presentation.client;

import com.dalhousie.group14.BusinessLogic.client.ProjectValidation;
import com.dalhousie.group14.Database.client.ProjectDatabaseInteraction;

import java.util.Scanner;

public class Project {

    public boolean defineproject(){
        ProjectValidation projectValidation = new ProjectValidation();
        ProjectDatabaseInteraction projectDatabaseInteraction = new ProjectDatabaseInteraction();
        Scanner s = new Scanner(System.in);
        Project projectobj = new Project();
        boolean done = false;
        System.out.println();
        System.out.println("Welcome to the project definition module");
        while (!done){
            System.out.print("Enter the project name : ");
            String projectname = s.nextLine();
            if (projectValidation.isStringvalid(projectname)) {
                if (projectDatabaseInteraction.projectexistscheck(projectname)) {
                    done = true;
                } else {
                    System.out.println("This project already exists, change the project name to continue.");
                }
            }
        }
        System.out.println();
        done = false;
        System.out.println("Now, you will need to enter the programming languages for the project.");
        System.out.println("Enter 'DONE' when you have finished entering the languages.");

        return true;

    }
}
