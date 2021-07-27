package com.dalhousie.group14.BusinessLogic.employee;

import org.testng.annotations.Test;

//import org.junit.Assert.*;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class NewEmployeeBusinessTest {
//  @Test
//  public void Login(){
//    NewEmployeeBusiness newEmployeeBusiness=new NewEmployeeBusiness();
//    assertEquals(true,newEmployeeBusiness.Login("tempFakeUserName","abc"));
//  }

  @Test
  public void userNameValidation(){
    NewEmployeeBusiness newEmployeeBusiness=new NewEmployeeBusiness();
    assertEquals(false,newEmployeeBusiness.userNameValidtion("ninads79shukla" +
            "@gmail.com"));
    assertEquals(true,newEmployeeBusiness.userNameValidtion("ninads79shukla"));
  }

  @Test
  public void passwordValidation(){
    NewEmployeeBusiness newEmployeeBusiness=new NewEmployeeBusiness();
    assertEquals(false,newEmployeeBusiness.passwordValidtion("123"));
    assertEquals(true,newEmployeeBusiness.passwordValidtion("ninads79shukla" +
            "@gmail.com"));
  }

  @Test
  public void applyjoinRequest(){
    NewEmployeeBusiness newEmployeeBusiness=new NewEmployeeBusiness();
    assertEquals(true,newEmployeeBusiness.applyjoinRequest("tempFakeUserName",
            "ninads79shukla",
            "ninnnnnnnnn"));
  }

}