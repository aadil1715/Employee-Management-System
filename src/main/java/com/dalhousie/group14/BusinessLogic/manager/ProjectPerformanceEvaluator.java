package com.dalhousie.group14.BusinessLogic.manager;

import com.dalhousie.group14.BusinessLogic.utilities.Validations;
import com.dalhousie.group14.Database.manager.EmployeeProjectPerformance;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ProjectPerformanceEvaluator {
  String pattern = "yyyy-MM-dd";
  public static final int FULLRATING = 10;
  public static final int PROJECTS_CONSIDERING = 2;
  public static final int DIVIDER = 2;
  public static final int ZERO = 0;
  public static final int MAX_DEADLINE = 5;
  public static final int GOOD_RATING = 1;

  public Map<String, Float> evalProjPerformanceAll() {
    float final_proj_rating = 0;
    ResultSet resultSet = EmployeeProjectPerformance.projectPerformanceAll();
    Map<String, Float> projPerformance = new HashMap<>();
    if (resultSet != null) {
      while (true) {
        try {
          if (!resultSet.next()) break;
          String employeeID = resultSet.getString("EmployeeID");
          String projectsString = resultSet.getString("ProjectHistory");
          List<String> projectsList =
              Arrays.asList(projectsString.split(","));
          List<String> eligibleProjects =
              EmployeeProjectPerformance.eligibleProjects(projectsList);
          String[] projectsArray =
              eligibleProjects.toArray(new String[eligibleProjects.size()]);
          if (eligibleProjects.size() >= PROJECTS_CONSIDERING) {
            final_proj_rating = projEvaluator(projectsArray);
          }
          if (final_proj_rating != ZERO) {
            projPerformance.put(employeeID, final_proj_rating);
          }

        } catch (SQLException e) {
          System.out.println("Error! Encountered while trying to read records. Log back into the application again.");
        }
      }
    }
    return projPerformance;
  }

  private float projEvaluator(String[] projectsArray) {
    float final_proj_rating = 0;
    if (projectsArray.length >= PROJECTS_CONSIDERING) {
      String clientfeedback = "";
      float cummulitative = 0;
      SimpleDateFormat sdf = new SimpleDateFormat(pattern);
      sdf.setLenient(false);
      for (int i = 0; i < PROJECTS_CONSIDERING; i++) {
        ResultSet resultSet2 = EmployeeProjectPerformance.projectPerformance(projectsArray[i]);
        ResultSet resultSet1 = EmployeeProjectPerformance.EmpProjectMilestones(projectsArray[i]);
        try {
          if (resultSet2.isBeforeFirst()) {
            resultSet2.next();
            clientfeedback = resultSet2.getString("ClientFeedback");
          }
          if (resultSet1!=null && resultSet1.isBeforeFirst()) {
            while (resultSet1.next()) {
              String deadline_date = resultSet1.getString("Deadline");
              String completion_date = resultSet1.getString("CompletionDate");
              Date deadlinedate = sdf.parse(deadline_date);
              Date completiondate = sdf.parse(completion_date);
              boolean beforedeadline = Validations.datecomparison(completiondate, deadlinedate);
              if (beforedeadline) {
                float client_rating = Integer.parseInt(clientfeedback);
                float work_rating = FULLRATING;
                float pro = (client_rating + work_rating) / DIVIDER;
                cummulitative = cummulitative + pro;
              } else {
                if (Validations.addDaystoDate(deadlinedate, MAX_DEADLINE).before(completiondate)) {
                  float client_rating = Integer.parseInt(clientfeedback);
                  float work_rating = FULLRATING - GOOD_RATING;
                  float pro = (client_rating + work_rating) / DIVIDER;
                  cummulitative = cummulitative + pro;
                }
              }
            }
          }
        } catch (SQLException | ParseException e) {
          System.out.println("Error Encountered");
        }
      }
      final_proj_rating = cummulitative / PROJECTS_CONSIDERING;
    }
    return final_proj_rating;
  }

  public float evalProjPerformOne(String userName) {
    ResultSet resultSet = EmployeeProjectPerformance.employeeProjectPerformance(userName);
    float final_rating = 0;
    try {
      if (resultSet.isBeforeFirst()) {
        while (resultSet.next()) {
          String projects_list = resultSet.getString("ProjectHistory");
          String[] projectsArray = projects_list.split(",");
          final_rating = projEvaluator(projectsArray);
        }
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return final_rating;
  }


}
