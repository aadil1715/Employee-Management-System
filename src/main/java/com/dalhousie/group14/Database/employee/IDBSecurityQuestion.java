package com.dalhousie.group14.Database.employee;

import java.util.ArrayList;

public interface IDBSecurityQuestion {

  void setSecurityQuestionFirstTime(String username);

  ArrayList<String> getSecurityQuestion(String username);

  void insertSecurityAnswer(String username, String answer1,
                            String answer2, String answer3);

  void employeeValidate(String user_name, String ans);

  void updateSecurityQuestion(String username, String question1,
                              String question2, String question3);

  void updateSecurityAnswer(String username, String answer1,
                            String answer2, String answer3);
}
