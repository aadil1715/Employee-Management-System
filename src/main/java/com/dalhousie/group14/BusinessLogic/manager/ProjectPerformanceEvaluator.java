package com.dalhousie.group14.BusinessLogic.manager;

import com.dalhousie.group14.BusinessLogic.utilities.Validations;
import com.dalhousie.group14.Database.manager.EmployeeProjectPerformance;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProjectPerformanceEvaluator implements ProjPerformanceProperties {
    public Map<String, Float> evalProjPerformanceAll() {
        ResultSet resultSet = EmployeeProjectPerformance.projectperformanceall();
        Map<String, Float> projperformance = new HashMap<>();
        if (resultSet != null) {
            while (true) {
                try {
                    if (!resultSet.next()) break;
                    String username = resultSet.getString("userName");
                    String projects_list = resultSet.getString("ProjectHistory");
                    float final_proj_rating =  ProjEvaluator(username,projects_list);
                    projperformance.put(username, final_proj_rating);

                } catch (SQLException e) {
                    System.out.println("Error! Encountered while trying to read records. Log back into the application again.");
                }
            }
        }
        return projperformance;
    }

    private float ProjEvaluator(String username, String projects_list) {
        String[] projects = projects_list.split(",");
        String clientfeedback = "";
        float cummulitative = 0;
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        for (int i = 0; i < projects_considering; i++) {
            ResultSet resultSet1 = EmployeeProjectPerformance.EmpProjectMilestones(projects[i]);
            ResultSet resultSet2 = EmployeeProjectPerformance.employeeprojectperformance(username);
            try {
                if (resultSet2.isBeforeFirst()) {
                    resultSet2.next();
                    clientfeedback = resultSet2.getString("Client_Feedback");

                }
                if (resultSet1.isBeforeFirst()) {
                    while (resultSet1.next()) {
                        String deadline_date = resultSet1.getString("Deadline");
                        String completion_date = resultSet1.getString("CompletionDate");
                        Date deadlinedate = sdf.parse(deadline_date);
                        Date completiondate = sdf.parse(completion_date);
                        boolean beforedeadline = Validations.datecomparison(completiondate, deadlinedate);
                        if (beforedeadline) {
                            int client_rating = Integer.parseInt(clientfeedback);
                            int work_rating = fullrating;
                            float pro = (client_rating + work_rating) / divider;
                            cummulitative = cummulitative + pro;
                        } else {
                            if (Validations.addDaystoDate(deadlinedate, max_deadline).before(completiondate)) {
                                int client_rating = Integer.parseInt(clientfeedback);
                                int work_rating = fullrating - good;
                                float pro = (client_rating + work_rating) / divider;
                                cummulitative = cummulitative + pro;
                            }
                        }
                    }
                }
            } catch (SQLException | ParseException e) {
                System.out.println("Error Encountered");
            }
        }
        float final_proj_rating = cummulitative / projects_considering;
        return final_proj_rating;
    }

    public float evalProjPerformOne(String username){
        ResultSet resultSet = EmployeeProjectPerformance.employeeprojectperformance(username);
        float final_rating = 0;
        try {
            if(resultSet.isBeforeFirst()){
                while (resultSet.next()){
                    String projects_list = resultSet.getString("ProjectHistory");
                    final_rating = ProjEvaluator(username,projects_list);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return final_rating;
    }



}
