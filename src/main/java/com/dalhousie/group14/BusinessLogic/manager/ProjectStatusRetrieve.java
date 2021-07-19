package com.dalhousie.group14.BusinessLogic.manager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjectStatusRetrieve {
  public static List<String> projectList(ResultSet resultSet){
    List<String> projects = new ArrayList<>();
    int Sno = 1;
    try{
      while (resultSet.next()){
        String ProjectID = resultSet.getString("ProjectID");
        String ProjectName = resultSet.getString("ProjectName");
        String ProjectLanguages = resultSet.getString("ProjectLanguages");
        String ProjectStartDate = resultSet.getString("ProjectStartDate");
        String ProjectEndDate = resultSet.getString("ProjectEndDate");
        String ProjectStatus = resultSet.getString("ProjectStatus");
        String proj = Sno+ " " + ProjectID + " " + ProjectName + " "
            + ProjectLanguages + " " + ProjectStartDate + " " + ProjectEndDate
              + " " + ProjectStatus;

        projects.add(proj);
        Sno++;
      }
    }catch (SQLException throwables){
      return null;
    }

    return projects;
  }
}
