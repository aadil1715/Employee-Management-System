package com.dalhousie.group14.BusinessLogic.employee;

import org.junit.Test;

import static org.junit.Assert.*;

public class NewEmployeeBusinessTest {
  @Test
  public void Login(){
    NewEmployeeBusiness newEmployeeBusiness=new NewEmployeeBusiness();
    assertEquals(true,newEmployeeBusiness.Login("tempFakeUserName","abc"));
  }

  @Test
  public void userNameValidation(){
    NewEmployeeBusiness newEmployeeBusiness=new NewEmployeeBusiness();
    assertEquals(false,newEmployeeBusiness.userNameValidtion("ninads79shukla" +
            "@gmail.com"));
    assertEquals(true,"ninads79shukla");
  }

}