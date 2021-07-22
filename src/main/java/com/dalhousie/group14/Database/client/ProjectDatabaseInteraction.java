package com.dalhousie.group14.Database.client;

import com.dalhousie.group14.Database.utilities.QueryExecutor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public class ProjectDatabaseInteraction {
  public static final String pattern = "yyyy-MM-dd";
  public static final SimpleDateFormat sdf = new SimpleDateFormat(pattern);

  public boolean insertprojectDB(String project_name, Date start_date, Date end_date, ArrayList<String> languages, Map<Date, String> milestones) {
    String projectlanguages = String.join(", ", languages);
    String project_status = "Initiation";
    String query = "INSERT INTO Project (ProjectName, ProjectLanguages, ProjectStartDate, ProjectEndDate, ProjectStatus)"
        + "Values('" + project_name + "','" + projectlanguages + "','" + sdf.format(start_date) + "','" + sdf.format(end_date)
        + "','" + project_status + "')";
    QueryExecutor.writeData(query);
    query = "Select ProjectID from Project where ProjectName='" + project_name + "';";
    ResultSet resultSet = QueryExecutor.readData(query);
    int projectid;
    try {
      if (resultSet.isBeforeFirst()) {
        resultSet.next();
        String incoming = resultSet.getString("ProjectID");
        projectid = Integer.parseInt(incoming);
        MilestonesDatabaseInteraction.insertmilestones(projectid, milestones);
        return true;
      }
    } catch (SQLException | NumberFormatException throwables) {
      throwables.printStackTrace();
    }
    return false;
  }

  public boolean projectexistscheck(String Projectname) {

    String query = "Select ProjectName from Project where ProjectName='" + Projectname + "';";
    ResultSet resultSet = QueryExecutor.readData(query);
    if (resultSet == null) {
      return true;
    }
    return false;
  }
}
