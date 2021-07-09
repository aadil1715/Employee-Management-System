package com.dalhousie.group14.Presentation.employee;

import com.dalhousie.group14.BusinessLogic.employee.Employee;
import com.dalhousie.group14.BusinessLogic.utilities.Salaries;
import org.junit.Test;

import static org.junit.Assert.*;

public class SalaryTest {

    @Test
    public void view() {
        Employee employee= new Employee("fakeUser");
        Salary salary=new Salary();
        salary.view(employee.getUserName());
    }
}