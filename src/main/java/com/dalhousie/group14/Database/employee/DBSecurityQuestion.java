package com.dalhousie.group14.Database.employee;

import com.dalhousie.group14.Database.utilities.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import static com.dalhousie.group14.Presentation.employee.EmployeeLoginDashBoard.employeeLoginDashBoard;

/**
 * Author- Jainam Shah(B00883898)
 * This class insert the Security Question with UserName into Database.
 */
public class DBSecurityQuestion implements IDBSecurityQuestion {


  @Override
  /*
   * This method take username as a parameter and insert data into database.
   * @param username
   */

  public void setSecurityQuestionFirstTime(String username) {

    String query;
    Scanner scanner = new Scanner(System.in);
    String question1;
    String question2;
    String question3;
    Statement statement;
    int result;
    System.out.println("Enter 1 Security Question");
    question1 = scanner.nextLine();
    System.out.println("Enter 2 Security Question");
    question2 = scanner.nextLine();
    System.out.println("Enter 3 Security Question");
    question3 = scanner.nextLine();

    query = ("insert into securityquestion (UserName,securityQuestion1,securityQuestion2,securityQuestion3)" +
        "values('" + username + "','" + question1 + "','" + question2 + "','" + question3 + "')");
    try {

      Connection connection = DbConnection.connectDB();
      statement = connection.createStatement();

      result = statement.executeUpdate(query);

      if (result > 0)
        System.out.println("successfully inserted");
      else
        System.out.println("Data not Inserted!! please, check your Username ");
    } catch (Exception e) {
      System.out.println("Exception:" + e);
    }
  }

  @Override
  /*This method take username as a parameter and retrive all the data from
   *database.
   */
  public ArrayList<String> getSecurityQuestion(String username) {

    ArrayList<String> arrayList = new ArrayList<>();
    String question1;
    String question2;
    String question3;

    String query = "select * from securityquestion where UserName= '" + username + "'";
    Statement stmt;
    ResultSet rs;
    {
      try {
        Connection connection = DbConnection.connectDB();
        stmt = connection.createStatement();
        rs = stmt.executeQuery(query);

        while (rs.next()) {
          username = rs.getString("UserName");
          arrayList.add(username);

          question1 = rs.getString("securityQuestion1");
          arrayList.add(question1);

          question2 = rs.getString("securityQuestion2");
          arrayList.add(question2);

          question3 = rs.getString("securityQuestion3");
          arrayList.add(question3);
        }

      } catch (SQLException throwables) {
        throwables.printStackTrace();
      }
      return arrayList;
    }
  }

  @Override
  /* This method Insert the Security Question Into Database.
   */
  public void insertSecurityAnswer(String userName, String answer1, String answer2, String answer3) {

    Statement statement;
    int result;
    String query = ("insert into securityanswer(UserName,securityAnswer1,securityAnswer2,securityAnswer3)" +
        "values('" + userName + "','" + answer1 + "','" + answer2 + "','" + answer3 + "')");
    try {
      Connection connection = DbConnection.connectDB();
      statement = connection.createStatement();
      result = statement.executeUpdate(query);
      if (result > 0)
        System.out.println("successfully inserted");
      else
        System.out.println("Answers not inserted!! Please check your userName: ");
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }

  @Override
  /* This method check the security answer given by employee is right or
  wrong. */
  public void employeeValidate(String userName, String answer) {

    Statement statement;
    ResultSet resultSet;
    String query;
    String answer1 = null;
    String answer2 = null;
    String answer3 = null;

    query = "select * from securityanswer where UserName='" + userName + "'";

    try {
      Connection connection = DbConnection.connectDB();
      statement = connection.createStatement();
      resultSet = statement.executeQuery(query);
      while (resultSet.next()) {
        answer1 = resultSet.getString("securityAnswer1");
        answer2 = resultSet.getString("securityAnswer2");
        answer3 = resultSet.getString("securityAnswer3");
      }
      if (answer.equalsIgnoreCase(answer1)) {
        employeeLoginDashBoard();
      } else if (answer.equalsIgnoreCase(answer2)) {
        employeeLoginDashBoard();
      } else if (answer.equalsIgnoreCase(answer3)) {
        employeeLoginDashBoard();
      } else {
        System.out.println("Please enter correct value:");
      }

    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }

  @Override
  /* This method update the security Question in their respective row.
   */
  public void updateSecurityQuestion(String username, String question1, String question2, String question3) {

    int resultSet;
    Statement statement;

    String query = "UPDATE `ems`.`securityquestion` SET `securityQuestion1` = '" + question1 + "', `securityQuestion2` = '" + question2 + "', `securityQuestion3` = '" + question3 + "' WHERE (`UserName` = '" + username + "')";
    try {
      Connection connection = DbConnection.connectDB();
      statement = connection.createStatement();
      System.out.println("connect");
      resultSet = statement.executeUpdate(query);
      if (resultSet > 0) {
        System.out.println("Update Successfully");
      } else {
        System.out.println("Password not update please check your employee id.");
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }

  }

  @Override
  /* This method update the security Answer in their respective row.
   */
  public void updateSecurityAnswer(String username, String answer1, String answer2, String answer3) {

    int resultSet;
    Statement statement;

    String query = "UPDATE `ems`.`securityanswer` SET `securityAnswer1` = '" + answer1 + "' ,`securityAnswer2` = '" + answer2 + "' ,`securityAnswer3` = '" + answer3 + "' WHERE (`UserName` = '" + username + "')";
    try {
      Connection connection = DbConnection.connectDB();
      statement = connection.createStatement();
      resultSet = statement.executeUpdate(query);
      if (resultSet > 0) {
        System.out.println("Update Successfully");
      } else {
        System.out.println("Security Answer not update please check your employee id.");
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }
}

