package com.dalhousie.group14.Presentation.manager;

import com.dalhousie.group14.Presentation.Common.UserInput;

import java.text.ParseException;

public class PerformanceEvaluatorScreen implements EvaluatorInterface {

    public void evaluatoroptions(){
        int userinput = 0;
        boolean correctinput = true;
        System.out.println("Choose the following options from the options.");
        System.out.println("1. Show Performance Evaluation of All Employees.");
        System.out.println("2. Display Performance Evaluation of A Specific Employee.");
        System.out.println("3. Show the Best Performing Employees.");
        System.out.println("4. Show the Worst Performing Employees");
        System.out.println("5. Current Employee of the Month.");
        System.out.println("6. To go back to the previous screen. ");
        try{
            userinput  = UserInput.takeInt();
            if(userinput>low_limit && userinput<=high_limit){
                correctinput = true;
            }else{
                System.out.println("Wrong Input Choice.");
                evaluatoroptions();
            }
        }catch (NumberFormatException e){
            System.out.println("You can only enter an integer value");
        }


        if(correctinput){
            if(userinput == 1){

            }else if(userinput == 2){

            }else if(userinput == 3){

            }else if(userinput == 4){

            }else if(userinput == 5){

            }else if(userinput == 6){

            }
        }

    }

}
