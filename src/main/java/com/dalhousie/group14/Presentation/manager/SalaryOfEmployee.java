package com.dalhousie.group14.Presentation.manager;

import com.dalhousie.group14.BusinessLogic.employee.Employee;
import com.dalhousie.group14.BusinessLogic.utilities.Salaries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class SalaryOfEmployee {
    public void editSalary(String userName){
        ArrayList<String> toViewElements=new ArrayList<>();
        toViewElements.add("CTC");
        toViewElements.add("bonus");
        toViewElements.add("basic_salary");
        toViewElements.add("EPF");

        String exit="";
        do{

            System.out.println("This is the breakdown of "+userName+"'s salary");
            Employee employee= new Employee(userName);
            Salaries salary=new Salaries();
            Map<String,Double>map=new HashMap<String, Double>();
            map=salary.viewSalary(employee);
            int i=0;
            for(String sal:toViewElements){
                System.out.println(i+"------"+sal+"-----"+map.get(sal));
                i+=1;
            }
            Scanner sc=new Scanner(System.in);
            System.out.println("Please Enter the option you want to edit");

            int option=sc.nextInt();
            System.out.println("Please Enter the updated "+toViewElements.get(option));
            Double value=sc.nextDouble();
            Salaries s=new Salaries();
            if(option>toViewElements.size()||option<0){
                System.out.println("Wrong option");
            }
            if(s.updateSalary(userName,value,toViewElements.get(option))){

                System.out.println("Update Successful.Do you want to continue?[yes/no]");
                exit=sc.next();
            }
            else {
                System.out.println("Update UnSuccessful.Do you want to continue?[yes/no]");
                exit=sc.next();
            }


        }while (exit.equalsIgnoreCase("yes"));





    }
}
