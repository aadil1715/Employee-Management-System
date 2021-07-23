package com.dalhousie.group14.Presentation.manager;

import com.dalhousie.group14.BusinessLogic.manager.Manager;
import org.junit.Test;

import static org.junit.Assert.*;

public class SalaryOfEmployeeTest {

  @Test
  public void editSalary() {

    Manager manager = new Manager("fakeManager");
    SalaryOfEmployee se = new SalaryOfEmployee();
    se.editSalary("fakeUser");

  }

}