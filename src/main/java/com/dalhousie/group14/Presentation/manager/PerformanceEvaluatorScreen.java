package com.dalhousie.group14.Presentation.manager;

import com.dalhousie.group14.BusinessLogic.manager.EmpEvaluation;
import com.dalhousie.group14.BusinessLogic.manager.SessionEvaluator;
import com.dalhousie.group14.BusinessLogic.utilities.Validations;
import com.dalhousie.group14.Presentation.Common.UserInput;

import java.util.List;
import java.util.Map;


public class PerformanceEvaluatorScreen implements EvaluatorInterface {

    public void evaluatoroptions(){
        int userinput = 0;
        boolean correctinput = true;
        System.out.println("Choose the following options from the options.");
        System.out.println("1. Show Performance Evaluation of All Employees.");
        System.out.println("2. Display Performance Evaluation of A Specific Employee.");
        System.out.println("3. Show the Most Disciplined Employees.");
        System.out.println("4. Show the Least Disciplined Employees.");
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

        boolean done = false;
        while(!done){
            if(correctinput){
                if(userinput == 1){
                    EmpEvaluation obj = new EmpEvaluation();
                    List<Map.Entry<String,Float>> employees_evaluation = obj.EvaluateAll();
                    System.out.println("Here is the evaluation of all the eligible employees");
                    System.out.println("----------------------------------------------------");
                    System.out.println("Employee Username                  Employee Performance Rating");
                    for(int i = 0; i<employees_evaluation.size(); i++){
                        Map.Entry<String,Float> empeval = employees_evaluation.get(i);
                        String username = empeval.getKey();
                        Float rating = empeval.getValue();
                        System.out.println(username+"                         "+rating);
                    }
                    done  = true;

                }else if(userinput == 2){
                    System.out.println("Enter the employee userName");
                    String username = UserInput.takeString();
                    if(Validations.isStringvalid(username)){
                        done = true;
                       EmpEvaluation obj = new EmpEvaluation();
                       String employee_performance = obj.EvaluateEmployee(username);
                        System.out.println("Here is the evaluation of the entered employee");
                        System.out.println("----------------------------------------------------");
                        System.out.println(employee_performance);


                    }else{
                        System.out.println("Incorrect Input Format, Please enter correctly.");
                    }

                }else if(userinput == 3){
                    EmpEvaluation obj = new EmpEvaluation();
                    System.out.println("Here is the evaluation of the entered employee");
                    System.out.println("----------------------------------------------------");
                    System.out.println(obj.mostDisciplined());

                }else if(userinput == 4){
                    EmpEvaluation obj = new EmpEvaluation();
                    System.out.println("Here is the evaluation of the entered employee");
                    System.out.println("----------------------------------------------------");
                    System.out.println(obj.leastDisciplined());

                }else if(userinput == 5){
                    EmpEvaluation obj = new EmpEvaluation();
                    System.out.println("The following employee has won Employee of the Month!! ");
                    System.out.println("----------------------------------------------------");
                    System.out.println(obj.EoM());

                }else if(userinput == 6){

                }
            }
        }

    }

}
