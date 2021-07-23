package com.dalhousie.group14.Database.manager;

import com.dalhousie.group14.Database.utilities.QueryExecutor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProjectStatus {
  public static ResultSet checkStatus(String choice){
    String query = "Select * from Project where ProjectStatus='" + choice +
        "';";
    ResultSet resultSet = QueryExecutor.readData(query);
    if (resultSet == null){
      return null;
    }
    return resultSet;
  }

  public static ResultSet availableEmployees(){
    String query = "Select * from EmployeeTechDetails where Assigned='" + false + "';";
    ResultSet resultSet = QueryExecutor.readData(query);
    try {
      if (resultSet == null || !resultSet.isBeforeFirst()){
        return null;
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return resultSet;
  }
}
