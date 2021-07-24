package com.dalhousie.group14.BusinessLogic.employee;

/*@Author: Ria Shah
  @Name of File: IValidateResignRequestEmployee.java
  @Interface Description: This interface will only declare the validateName
  and validateReason methods
  which the base class ValidateResignRequestEmployee will implement.
 */
public interface IValidateResignRequestEmployee {

  boolean validateName(String name);

  boolean validateReason(String reason);

}
