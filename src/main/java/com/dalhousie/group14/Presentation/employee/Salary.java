package com.dalhousie.group14.Presentation.employee;

import com.dalhousie.group14.BusinessLogic.employee.Employee;

import java.util.Map;
import com.dalhousie.group14.BusinessLogic.utilities.Salaries;
public class Salary {
    public void view(String userName){
        System.out.println("Hello "+userName);

        System.out.println("Here is the breakdown of your salary");
        Employee employee= new Employee(userName);
        Salaries salary=new Salaries();
        for(Object e:salary.viewSalary(employee).entrySet()){
            System.out.println(e.toString());

        }


    }
}
