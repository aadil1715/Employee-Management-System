package com.dalhousie.group14.Presentation.utilities;

/*@Author:Ria Shah
  @Name of File: Print.java
  @Class Description: This class will print the string message
  passed as a parameter.
 */
public class Print implements IPrint {

  public String displayMessage(String str1) {
    try {
      return str1;
    } catch (Exception exception) {
      System.out.println(exception);
    }
    return null;
  }

}
