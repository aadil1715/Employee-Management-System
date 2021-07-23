package com.dalhousie.group14.Database.manager;

import com.dalhousie.group14.Database.utilities.QueryExecutor;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeProjectPerformance {
    public static ResultSet projectPerformanceAll() {
        ResultSet resultSet = null;
        String query = "select EmployeeID,ProjectHistory from EmployeeTechDetails where " +
            "ProjectHistory is not null";
        resultSet = QueryExecutor.readData(query);
        return resultSet;
    }

    public static ResultSet employeeProjectPerformance(String userName) {
        ResultSet resultSet = null;
        String query = "select ClientFeedbackStatus from Project where " +
            "ClientFeedbackStatus=true and ProjectID='"+userName+"';";
        resultSet = QueryExecutor.readData(query);

        return resultSet;
    }

    public static ResultSet projectPerformance(String projectID) {
        ResultSet resultSet = null;
        String query = "select ClientFeedbackStatus from Project where " +
            "ClientFeedbackStatus=true and ProjectID='"+projectID+"';";
        resultSet = QueryExecutor.readData(query);

        return resultSet;
    }

    public static ResultSet EmpProjectMilestones(String projectID){
        String query = "Select Deadline,CompletionDate from milestones where " +
            "ProjectID='"+projectID+"';";
        ResultSet resultSet= QueryExecutor.readData(query);

        return  resultSet;
    }

    public static void EmployeeofMonth(String username, Float rating){
        String query = "";
        QueryExecutor.writeData(query);
    }

    public static ResultSet DisplayEoM(){
        String query = "";
        ResultSet resultSet = QueryExecutor.readData(query);
        return resultSet;
    }

    public static List<String> eligibleProjects(List<String> projectsList){
        List<String> eligibleProjects = new ArrayList<>();
        String projectStatus = "Finished";
        for(int i =0 ; i<projectsList.size() ; i++){
            String query = "Select ClientFeedback from Project where " +
                "ProjectStatus='"+projectStatus+"' and ClientFeedback=true and " +
                "ProjectID='"+projectsList.get(i)+"';";
            ResultSet resultSet = QueryExecutor.readData(query);
            if(resultSet != null){
                eligibleProjects.add(projectsList.get(i));
            }
        }
        return eligibleProjects;
    }
}
