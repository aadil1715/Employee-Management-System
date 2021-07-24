package com.dalhousie.group14.Database.manager;

import com.dalhousie.group14.Database.utilities.QueryExecutor;
import com.dalhousie.group14.Presentation.utilities.TableFormatter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class EmployeeProjectPerformance {
  public static final int DRATING_INDEX = 1;
  public static final int PRATING_INDEX = 2;
  public static final int ERATING_INDEX = 0;
  public static ResultSet projectPerformanceAll() {
    ResultSet resultSet = null;
    String query = "select EmployeeID,ProjectHistory from EmployeeTechDetails where " +
        "ProjectHistory is not null";
    resultSet = QueryExecutor.readData(query);
    return resultSet;
  }

  public static void writeprojectPerformanceAll(Map<String,List<Float>> sortedEmpCompleteDetails) {
    Set<String> keys = sortedEmpCompleteDetails.keySet();
    int i = 0;
    for(String key : keys){
      String employeeID = key;
      List<Float> ratings = sortedEmpCompleteDetails.get(employeeID);
      float disciplineRating = ratings.get(DRATING_INDEX);
      float projectRating = ratings.get(PRATING_INDEX);
      float evaluationRating = ratings.get(ERATING_INDEX);
      boolean EoM = false;
      if (i == 0) {
        EoM = true;
      }
      String query = "INSERT INTO EmployeeRatings (EmployeeID, DisciplineRating," +
          " ProjectRating, EvaluationRating, EoM) VALUES('" + employeeID + "','"
          + disciplineRating + "','" + projectRating + "','"+evaluationRating+
          "',"+EoM+") ON DUPLICATE KEY UPDATE DisciplineRating ='" + disciplineRating + "', ProjectRating ='" + projectRating + "', EvaluationRating ='" + evaluationRating + "', EoM ="+EoM+";";
      QueryExecutor.writeData(query);
      i++;
    }
  }

  public static ResultSet employeeProjectPerformance(String userName) {
    ResultSet resultSet = null;
    String query = "select ClientFeedback from Project where " +
        "ClientFeedbackStatus=true and ProjectID='" + userName + "';";
    resultSet = QueryExecutor.readData(query);

    return resultSet;
  }

  public static ResultSet projectPerformance(String projectID) {
    ResultSet resultSet = null;
    String query = "select ClientFeedback from Project where " +
        "ClientFeedbackStatus=true and ProjectID='" + projectID + "';";
    resultSet = QueryExecutor.readData(query);

    return resultSet;
  }

  public static ResultSet EmpProjectMilestones(String projectID,
                                               String employeeID) {
    String query = "Select Deadline,CompletionDate from milestones where " +
        "ProjectID='" + projectID + "'and AssignedTo='" + employeeID + "';";
    ResultSet resultSet = QueryExecutor.readData(query);

    return resultSet;
  }


  public static String DisplayEoM() {
    String query = "Select EmployeeID, DisciplineRating, ProjectRating, EvaluationRating from EmployeeRatings " +
        "where EoM="+true+";";
    String employeeName = "";
    List<List<String>> displayEoMtable = new ArrayList<>();
    List<String> displayEoMheaders = Arrays.asList("Employee ID", "Employee " +
            "Name", "Discipline Rating","Project Rating", "Evaluation Rating");
    displayEoMtable.add(displayEoMheaders);
    ResultSet resultSet = QueryExecutor.readData(query);
    try {
      if(resultSet!=null && resultSet.isBeforeFirst()){
        resultSet.next();
        String employeeID = resultSet.getString("EmployeeID");
        query =
            "Select ContactName from Employee where EmployeeID='"+employeeID+
                "';";
        ResultSet resultSet1 = QueryExecutor.readData(query);
        if(resultSet1 != null){
          resultSet1.next();
          employeeName = resultSet1.getString("ContactName");
        }
        String disciplineRating = resultSet.getString("DisciplineRating");
        String projectRating = resultSet.getString("ProjectRating");
        String evaluationRating = resultSet.getString("EvaluationRating");
        List<String> displayEoMRow = Arrays.asList(employeeID, employeeName,
            disciplineRating,projectRating,evaluationRating);
        displayEoMtable.add(displayEoMRow);
      }
    } catch (SQLException throwables) {
      return null;
    }

    return TableFormatter.formatAsTable(displayEoMtable);
  }

  public static List<String> eligibleProjects(List<String> projectsList) {
    List<String> eligibleProjects = new ArrayList<>();
    String projectStatus = "Finished";
    for (int i = 0; i < projectsList.size(); i++) {
      String query = "Select ClientFeedback from Project where " +
          "ProjectStatus='" + projectStatus + "' and ClientFeedbackStatus=true and " +
          "ProjectID='" + projectsList.get(i) + "';";
      ResultSet resultSet = QueryExecutor.readData(query);
      if (resultSet != null) {
        eligibleProjects.add(projectsList.get(i));
      }
    }
    return eligibleProjects;
  }
}
