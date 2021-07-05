package com.dalhousie.group14;
import java.text.ParseException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Client {

    public static void main(String[] args) {
        Client obj = new Client();
        obj.clientscreen();

    }


    private void clientscreen() {
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
                if (optionchosen > 0 && optionchosen < 4) {
                    correctoption = true;
                    break;
                }
            } catch (Exception e) {
                if (i < 2) {
                    System.out.print("Incorrect Input, Enter your input again : ");
                } else {
                    System.out.println("You have used all your attempts, log back into the application.");
                }
            }
        }
        if (correctoption) {
            if (optionchosen == 1) {
                projectdefinition();
            } else if (optionchosen == 2) {
                projectstatus();
            } else {
                projectfeedback();
            }
        }
    }

    private void projectdefinition() {
        boolean done = false;
        int count = 1;
        Scanner s = new Scanner(System.in);
        Project obj = new Project();
        Date start_date = new Date();
        Date end_date = new Date();
        System.out.println();
        System.out.println("Welcome to the project definition module");
        while (!done){
            System.out.print("Enter the project name : ");
            String projectname = s.nextLine();
            if (isStringvalid(projectname)) {
                if (obj.projectexistscheck(projectname)) {
                    obj.project_name = projectname;
                    done = true;
                } else {
                    System.out.println("This project already exists, change the project name to continue.");
                }
            }
        }
        System.out.println();
        done = false;
        System.out.println("Enter 'DONE' when you have finished entering the languages.");
        while(!done){

            System.out.print("Enter the "+ noreturn(count)+" programming language that will be used for this project : ");
            count++;
            String languageinput = s.next();
            if(languageinput.equals("DONE")){
                done = true;
                break;
            }
            if(isStringvalid(languageinput)){
                obj.language_requirements.add(languageinput);
            }else{
                System.out.println("Invalid Language has been entered, please enter again, enter 'DONE' when you have finished");
                count--;
            }
        }
        done = false;
        boolean startvalid = false;
        while(!done){
            Scanner scanner = new Scanner(System.in);
            System.out.println();

            if(!startvalid) {
                System.out.print("Enter the project's start date : ");
                String project_start_date = scanner.nextLine();
                start_date = datesetter(obj,project_start_date);
                if(start_date!=null) {
                    obj.project_start = start_date;
                    startvalid = true;
                }
            }
            System.out.print("Enter the project's end date : ");
            String project_end_date = scanner.nextLine();
            end_date = datesetter(obj,project_end_date);
            if(end_date != null) {
                if(end_date.after(start_date)) {
                    obj.project_end = end_date;
                    done = true;
                }else{
                    System.out.println("Project's end date cannot be before the start date.");
                }
            }
        }

        boolean m1 = false;
        boolean m2= false;
        boolean m3 = false;
        while(!m1 && !m2 && !m3){
            Scanner sc = new Scanner(System.in);
            System.out.println();
            if(!m1){
                System.out.print("Enter the 1st Milestone's Description : ");
                String milestone = sc.nextLine();
                obj.milestone_desc.put(1,milestone);
                System.out.print("Enter the 1st Milestone's Deadline Date : ");
                String milestone1_date = sc.nextLine();
                Date m1_date = datesetter(obj, milestone1_date);
                if(m1_date != null && m1_date.after(start_date) && m1_date.before(end_date)){
                    obj.milestone_deadlines.put(1,m1_date);
                    m1 = true;
                }

            }
            if(!m2){
                System.out.print("Enter the 2nd Milestone's Description : ");
                String milestone2 = sc.nextLine();
                obj.milestone_desc.put(2,milestone2);
                System.out.print("Enter the 2nd Milestone's Deadline Date : ");
                String milestone2_date = sc.next();
                Date m2_date = datesetter(obj, milestone2_date);
                if(m2_date != null && m2_date.after(start_date) && m2_date.before(end_date)){
                    obj.milestone_deadlines.put(2,m2_date);
                    m2=true;
                }else{
                    System.out.println("Milestone Date should be between the project timelines");
                }

            }
            if(!m3){
                sc.nextLine();
                System.out.print("Enter the 3rd Milestone's Description : ");
                String milestone3 = sc.nextLine();
                obj.milestone_desc.put(3,milestone3);
                System.out.print("Enter the 3rd Milestone's Deadline Date : ");
                String milestone3_date = sc.next();
                Date m3_date = datesetter(obj, milestone3_date);
                if(m3_date != null && m3_date.after(start_date) && m3_date.before(end_date)){
                    obj.milestone_deadlines.put(3,m3_date);
                    m3=true;
                    obj.projectDBinsertion();

                }
            }

        }


    }


    private Date datesetter(Project obj, String date){

        try{
            return obj.sdf.parse(date);

        }catch (ParseException e){
            System.out.println("Invalid Date format - Follow dd-MM-YYYY Format.");

        }

        return null;
    }


    private boolean isStringvalid(String input){
        if(input==null || input.isEmpty()){
            return false;
        }

        Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(input);
        boolean b = m.find();
        return !b;
    }



    private void projectstatus(){
    }

    private void projectfeedback(){

    }

    public static String noreturn(int i) {
        String[] suffixes = new String[] { "th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th" };
        switch (i % 100) {
            case 11:
            case 12:
            case 13:
                return i + "th";
            default:
                return i + suffixes[i % 10];

        }
    }
}
