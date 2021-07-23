package com.dalhousie.group14.BusinessLogic.manager;

import com.dalhousie.group14.Database.manager.EmployeeProjectPerformance;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EmpEvaluation implements IEmpEvaluation {


  public List<Map.Entry<String, Float>> EvaluateAll() {
    SessionEvaluator obj = new SessionEvaluator();
    Map<String, Float> emp_performance = new HashMap<>();
    ProjectPerformanceEvaluator obj2 = new ProjectPerformanceEvaluator();
    Map<String, Float> empsessions = obj.evaluateAllSessions();
    Map<String, Float> empprojectperformance = obj2.evalProjPerformanceAll();
    Set<String> empsessions_keys = empsessions.keySet();
    Set<String> empprojectperformance_keys = empprojectperformance.keySet();
    empprojectperformance_keys.retainAll(empsessions_keys);

    for (String s : empprojectperformance_keys) {
      float performance_rating = empprojectperformance.get(s);
      float discipline_rating = empsessions.get(s);
      float total_rating = (performance_rating + discipline_rating) / 2;
      emp_performance.put(s, total_rating);
    }

    List<Map.Entry<String, Float>> sorted_performance = EvaluatorComparator.entriesSortedByValues(emp_performance);
    Map.Entry<String, Float> EoM = sorted_performance.get(0);
    String EoM_username = EoM.getKey();
    float EoM_rating = EoM.getValue();
    EmployeeProjectPerformance.EmployeeofMonth(EoM_username, EoM_rating);

    return sorted_performance;
  }

  @Override
  public String EvaluateEmployee(String username) {
    SessionEvaluator obj = new SessionEvaluator();
    ProjectPerformanceEvaluator obj2 = new ProjectPerformanceEvaluator();
    float discipline_rating = obj.evaluateEmployeeSession(username);
    float performance_rating = obj2.evalProjPerformOne(username);
    float total_rating = (discipline_rating + performance_rating) / 2;
    String display = username + " - " + total_rating;

    return display;
  }

  @Override
  public String mostDisciplined() {
    SessionEvaluator obj = new SessionEvaluator();
    return obj.topEmployees();
  }

  @Override
  public String leastDisciplined() {
    SessionEvaluator obj = new SessionEvaluator();
    return obj.bottomEmployees();
  }

  @Override
  public String EoM() {
    ResultSet resultSet = EmployeeProjectPerformance.DisplayEoM();
    String display = "";

    try {
      if (resultSet.isBeforeFirst()) {
        resultSet.next();
        String username = resultSet.getString("userName");
        String rating = resultSet.getString("Rating");
        display = username + "                 " + rating;
      }
    } catch (SQLException throwables) {
      System.out.println("Not able to display Employee of the Month at this " +
          "time.");
    }

    return display;
  }

}
