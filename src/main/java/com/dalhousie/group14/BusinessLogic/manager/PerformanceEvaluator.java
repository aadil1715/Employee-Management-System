package com.dalhousie.group14.BusinessLogic.manager;

import com.dalhousie.group14.Database.manager.EmployeeSessions;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PerformanceEvaluator implements EvaluatorProperties {
    Map<String, ArrayList<String>> employeesessions = new HashMap<>();
    Map<String, Float> emp_discipline_rating = new HashMap<>();

    public void evaluateAll() {
        ResultSet resultset = EmployeeSessions.getEmployeeSessions();
        if (resultset != null) {
            while (true) {
                try {
                    if (!resultset.next()) {
                        break;
                    }
                    String username = resultset.getString("userName");
                    String session_time = resultset.getString("minutes");
                    sessionmanager(username,session_time);

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        sessionanalysis();




    }

    public String evaluateEmployee(String userName){
        return "ok";

    }

    public void topEmployees(){

    }

    public void bottomEmployees(){

    }

    private void sessionmanager(String username, String minutes) {
        if (!employeesessions.containsKey(username)) {
            ArrayList dailysession = new ArrayList();
            dailysession.add(minutes);
            employeesessions.put(username, dailysession);
        } else {
            ArrayList<String> dailysession = employeesessions.get(username);
            dailysession.add(minutes);
            employeesessions.put(username, dailysession);
        }

    }

    private void sessionanalysis() {
        Set<String> keyset = employeesessions.keySet();
        for (String s : keyset) {
            ArrayList<String> monthsessions = employeesessions.get(s);
            int cummulitative_rating = 0;
            for (int i = 0; i < monthsessions.size(); i++) {
                String minutes = monthsessions.get(i);
                int day_rating = sessionrate(minutes);
                cummulitative_rating = cummulitative_rating + day_rating;
            }
            float employee_rating = (cummulitative_rating / days) * 100;
            emp_discipline_rating.put(s, employee_rating);
        }

    }

    private int sessionrate(String minutes) {
        int session_minutes = Integer.parseInt(minutes);
        int difference = maximumsession - session_minutes;
        int rating_differential = difference % 10;
        int finalrating = maxrating - rating_differential + 1;
        return finalrating;
    }
}
