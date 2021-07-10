package com.dalhousie.group14.Presentation.client;

import com.dalhousie.group14.BusinessLogic.client.ProjectDefinition;
import com.dalhousie.group14.BusinessLogic.utilities.Validations;
import com.dalhousie.group14.Database.client.ProjectDatabaseInteraction;

import java.util.*;

public class Project {

    public boolean defineproject(){
        ProjectDatabaseInteraction projectDatabaseInteraction = new ProjectDatabaseInteraction();
        ProjectDefinition projectDefinition = new ProjectDefinition();
        Scanner s = new Scanner(System.in);
        Project projectobj = new Project();
        String projectname = "";
        boolean done = false;
        System.out.println();
        System.out.println("Welcome to the project definition module");
        while (!done){
            System.out.print("Enter the project name : ");
            projectname = s.nextLine();
            if (Validations.isStringvalid(projectname)) {
                if (projectDatabaseInteraction.projectexistscheck(projectname)) {
                    done = true;
                } else {
                    System.out.println("This project already exists, change the project name to continue.");
                }
            }
        }
        System.out.println();
        System.out.println("Now, you will need to enter the programming languages for the project.");
        System.out.println("Enter 'DONE' when you have finished entering the languages.");
        int count = 1;
        ArrayList<String> language_requirements = new ArrayList<>();
        done = false;
        while(!done){

            System.out.print("Enter the "+ Validations.noreturn(count)+" programming language that will be used for this project : ");
            count++;
            String languageinput = s.next();
            if(languageinput.equals("DONE")){
                done = true;
                break;
            }
            if(Validations.isStringvalid(languageinput)){
                language_requirements.add(languageinput);
            }else{
                System.out.println("Invalid Language has been entered, please enter again, enter 'DONE' when you have finished");
                count--;
            }
        }
        done = false;
        Date start_date = new Date();
        Date end_date = new Date();
        boolean startvalid = false;
        while(!done){
            Scanner scanner = new Scanner(System.in);
            System.out.println();

            if(!startvalid) {
                System.out.print("Enter the project's start date : ");
                String project_start_date = scanner.nextLine();
                start_date = projectDefinition.datesetter(project_start_date);
                if(start_date!=null) {
                    startvalid = true;
                }else{
                    System.out.println("Invalid Date format - Follow dd-MM-YYYY Format.");
                }
            }
            System.out.print("Enter the project's end date : ");
            String project_end_date = scanner.nextLine();
            end_date = projectDefinition.datesetter(project_end_date);
            if(end_date != null) {
                if(Validations.datecomparison(start_date,end_date)) {
                    done = true;
                }else{
                    System.out.println("Project's end date cannot be before the start date.");
                }
            }
        }
        if(done){
            MilestonesDashboard obj = new MilestonesDashboard();
            ProjectDatabaseInteraction obj2 = new ProjectDatabaseInteraction();
            Map<Date,String> milestones = obj.definemilestonescreen(start_date,end_date);
            if(milestones != null){
                obj2.insertprojectDB(projectname,start_date, end_date,language_requirements,milestones);
                return true;
            }
        }
        return false;
    }


}
