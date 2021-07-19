package com.dalhousie.group14.Database.manager;

import com.dalhousie.group14.Database.utilities.QueryExecutor;

import java.sql.ResultSet;

public class ProjectStatus {
  public static ResultSet checkStatus(String choice){
    String query = "Select ProjectID from Project where ProjectStatus='" + choice + "';";
    ResultSet resultSet = QueryExecutor.readData(query);
    if (resultSet == null){
      return null;
    }
    return resultSet;
  }

  public static ResultSet availableEmployees(){
    String query = "Select * from Project where Assigned='" + false + "';";
    ResultSet resultSet = QueryExecutor.readData(query);
    if (resultSet == null){
      return null;
    }
    return resultSet;
  }
}
