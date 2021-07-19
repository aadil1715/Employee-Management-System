package com.dalhousie.group14.BusinessLogic.employee;

import org.junit.Test;

import static org.junit.Assert.*;

public class NewEmployeeBusinessTest {
  @Test
  void Login(){
    NewEmployeeBusiness newEmployeeBusiness=new NewEmployeeBusiness();
    assertEquals(true,newEmployeeBusiness.Login("tempFakeUserName","abc"));
  }

}