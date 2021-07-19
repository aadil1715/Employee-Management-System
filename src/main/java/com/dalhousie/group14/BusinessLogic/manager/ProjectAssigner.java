package com.dalhousie.group14.BusinessLogic.manager;

import com.dalhousie.group14.BusinessLogic.utilities.CommonConstants;
import com.dalhousie.group14.Database.manager.EmployeeProjectAssign;
import com.dalhousie.group14.Database.manager.ProjectStatus;
import com.dalhousie.group14.Presentation.manager.ProjectManagement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class ProjectAssigner implements CommonConstants {
  int assigned = min;
  Set<String> assignedemployees = new HashSet<>();
  Map<String, List<String>> empInfo = new HashMap<>();

  public boolean assignproject(String projectInfo) {
    String[] projectValues = projectInfo.split(" ");
    String projectID = projectValues[ID];
    String projectLanguages = projectValues[languages];
    List<String> requiredlanguages = languageformatter(projectLanguages);
    ResultSet resultSet = ProjectStatus.availableEmployees();

    while (true) {
      try {
        if (!resultSet.next()) {
          break;
        }
        String languages = resultSet.getString("Languages");
        List<String> employeeLanguages = languageformatter(languages);
        String empID = resultSet.getString("EmployeeID");
        empInfo.put(empID, employeeLanguages);
      } catch (SQLException throwables) {
        throwables.printStackTrace();
      }
    }
    Set<String> assignedEmployees = empAssigner(requiredlanguages);
    if (assignedEmployees == null) {
      return false;
    }

    return EmployeeProjectAssign.assignEmp(projectID,assignedEmployees);
  }

  public Set<String> empAssigner(List<String> requiredlanguages) {
    if (assignPerfectFit(requiredlanguages)) {
      return assignedemployees;
    } else if (assignDuoFit(requiredlanguages)) {
      return assignedemployees;
    } else {
      ProjectManagement obj = new ProjectManagement();
      if (obj.assignAny() && assignAnyFit()) {
        return assignedemployees;
      }
    }
    return null;
  }


  public boolean assignPerfectFit(List<String> requiredlanguages) {
    Set<String> keys = empInfo.keySet();
    List<String> emplanguages;

    for (String key : keys) {
      emplanguages = empInfo.get(key);

      if (emplanguages.containsAll(requiredlanguages)) {
        assignedemployees.add(key);
        empInfo.remove(key);
        assigned++;
      }
      if (assigned == completeassigned) {
        return true;
      }
    }

    return false;
  }

  public boolean assignDuoFit(List<String> requiredlanguages) {
    Set<String> keys = empInfo.keySet();
    List<String> emplanguages;
    List<String> singleFitemployees = new ArrayList<>();
    for (String key : keys) {
      int lcount = min;
      emplanguages = empInfo.get(key);
      for (String emplanguage : emplanguages) {
        if (requiredlanguages.contains(emplanguage)) {
          lcount++;
        }
        if (lcount > 1) {
          assignedemployees.add(key);
          empInfo.remove(key);
          assigned++;
        }
        if (assigned == maxtries) {
          return true;
        }
        if (emplanguages.get(emplanguages.size() - 1).equals(emplanguage) && lcount == 1) {
          singleFitemployees.add(key);
        }
      }
    }
    if (assignSingleFit(singleFitemployees)) {
      return true;
    }

    return false;
  }

  public boolean assignSingleFit(List<String> singleFitemployees) {
    int i = 0;
    while (i < singleFitemployees.size()) {
      assignedemployees.add(singleFitemployees.get(i));
      empInfo.remove(singleFitemployees.get(i));
      assigned++;
      i++;
    }
    if (assigned == completeassigned) {
      return true;
    }

    return false;
  }

  public boolean assignAnyFit() {
    Set<String> keys = empInfo.keySet();
    for (String key : keys) {
      assignedemployees.add(key);
      empInfo.remove(key);
      assigned++;
      if (assigned == completeassigned) {
        return true;
      }
    }
    return false;
  }

  public List<String> languageformatter(String languages) {
    String[] languageArray = languages.split(",");
    List<String> languageList = new ArrayList<>();
    for (String language : languageArray) {
      String formatLanguage = language.trim();
      languageList.add(formatLanguage);
    }

    return languageList;
  }

}
