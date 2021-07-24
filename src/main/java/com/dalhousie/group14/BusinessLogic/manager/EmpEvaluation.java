package com.dalhousie.group14.BusinessLogic.manager;

import com.dalhousie.group14.Database.manager.EmployeeProjectPerformance;
import com.dalhousie.group14.Presentation.utilities.TableFormatter;

import java.util.*;

public class EmpEvaluation implements IEmpEvaluation {
  public static final int DIVIDER = 2;
  public static final int NEGATIVECHECK = 0;


  public String EvaluateAll() {
    SessionEvaluator obj = new SessionEvaluator();
    Map<String, Float> emp_performance = new HashMap<>();
    ProjectPerformanceEvaluator obj2 = new ProjectPerformanceEvaluator();
    Map<String, Float> empsessions = obj.evaluateAllSessions();
    Map<String, Float> empprojectperformance = obj2.evalProjPerformanceAll();
    Set<String> empsessions_keys = empsessions.keySet();
    Set<String> empprojectperformance_keys = empprojectperformance.keySet();
    empprojectperformance_keys.retainAll(empsessions_keys);

    for (String s : empprojectperformance_keys) {
      float performanceRating = empprojectperformance.get(s);
      float disciplineRating = empsessions.get(s);
      float totalRating = (performanceRating + disciplineRating) / DIVIDER;
      totalRating = ((int) ((totalRating + 0.005f) * 100)) / 100f;
      emp_performance.put(s, totalRating);
    }

    List<Map.Entry<String, Float>> sortedPerformance = EvaluatorComparator.entriesSortedByValues(emp_performance);
    Map<String, List<Float>> sortedEmpCompleteDetails = new LinkedHashMap<>();
    List<List<String>> evaluationTable = new ArrayList<>();
    for (Map.Entry<String, Float> empeval : sortedPerformance) {
      String userID = empeval.getKey();
      String totalRatingString = String.valueOf(empeval.getValue());
      String disciplineRatingString = String.valueOf(empsessions.get(userID));
      String performanceRatingString =
          String.valueOf(empprojectperformance.get(userID));
      List<Float> ratings = Arrays.asList(empeval.getValue(),
          empsessions.get(userID), empprojectperformance.get(userID));
      sortedEmpCompleteDetails.put(userID, ratings);
      List<String> headers = Arrays.asList("Employee ID", "Discipline Rating"
          , "Project Performance Rating", "Employee Performance Rating");
      evaluationTable.add(headers);
      List<String> row = Arrays.asList(userID, disciplineRatingString,
          performanceRatingString, totalRatingString);
      evaluationTable.add(row);
    }
    EmployeeProjectPerformance.writeprojectPerformanceAll(sortedEmpCompleteDetails);
    return TableFormatter.formatAsTable(evaluationTable);
  }

  public String EvaluateEmployee(String userID) {
    SessionEvaluator obj = new SessionEvaluator();
    ProjectPerformanceEvaluator obj2 = new ProjectPerformanceEvaluator();
    List<List<String>> evaluationTable = new ArrayList<>();
    float disciplineRating = obj.evaluateEmployeeSession(userID);
    if(disciplineRating < NEGATIVECHECK){
      return null;
    }
    float performanceRating = obj2.evalProjPerformOne(userID);
    float totalRating = (disciplineRating + performanceRating) / DIVIDER;

    String disciplineRatingString = String.valueOf(disciplineRating);
    String performanceRatingString = String.valueOf(performanceRating);
    String totalRatingString = String.valueOf(totalRating);

    List<String> headers = Arrays.asList("Employee ID", "Discipline Rating"
        , "Project Performance Rating", "Employee Performance Rating");
    evaluationTable.add(headers);
    List<String> row = Arrays.asList(userID, disciplineRatingString,
        performanceRatingString, totalRatingString);
    evaluationTable.add(row);

    return TableFormatter.formatAsTable(evaluationTable);
  }


  public String mostDisciplined() {
    SessionEvaluator obj = new SessionEvaluator();
    return obj.topEmployees();
  }

  public String leastDisciplined() {
    SessionEvaluator obj = new SessionEvaluator();
    return obj.bottomEmployees();
  }

  public String EoMDisplay() {
    return EmployeeProjectPerformance.DisplayEoM();
  }

}
