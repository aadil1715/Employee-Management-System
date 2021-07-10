package com.dalhousie.group14.BusinessLogic.manager;

import com.dalhousie.group14.BusinessLogic.utilities.CommonConstants;
import com.dalhousie.group14.BusinessLogic.utilities.Validations;
import com.dalhousie.group14.Database.manager.EmployeeSessions;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;



public class SessionEvaluator implements SessionEvaluatorProperties, CommonConstants {


    public Map<String, Float> evaluateAllSessions() {
        Map<String, ArrayList<String>> employeesessions = new HashMap<>();
        Map<String, Float> emp_discipline_rating = new HashMap<>();
        Calendar calendar = Calendar.getInstance();
        Date final_date = Validations.datesetter(sdf.format(calendar.getTime()));
        ResultSet resultset = EmployeeSessions.getEmployeeSessions(final_date);
        employeesessions = sessionadder(resultset,employeesessions);
        emp_discipline_rating = sessionanalysis(employeesessions,emp_discipline_rating);
        return  emp_discipline_rating;

    }
    private Map<String, ArrayList<String>> sessionadder(ResultSet resultset,  Map<String, ArrayList<String>> employeesessions){
        if (resultset != null) {
            while (true) {
                try {
                    if (!resultset.next()) {
                        break;
                    }
                    String username = resultset.getString("UserName");
                    String session_time = resultset.getString("Minutes");
                    employeesessions = sessionmanager(username,session_time, employeesessions);

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return employeesessions;
    }

    public Float evaluateEmployeeSession(String userName){
        Map<String, ArrayList<String>> employeesessions = new HashMap<>();
        Map<String, Float> emp_discipline_rating = new HashMap<>();
        Calendar calendar = Calendar.getInstance();
        Date final_date = Validations.datesetter(sdf.format(calendar.getTime()));
        ResultSet resultset = EmployeeSessions.getEmployeeSession(userName, final_date);
        employeesessions = sessionadder(resultset,employeesessions);
        emp_discipline_rating = sessionanalysis(employeesessions,emp_discipline_rating);
        float session_rating = emp_discipline_rating.get(userName);
        return session_rating;
    }

    public String topEmployees(){
        List<Map.Entry<String, Float>> emp_discipline_rating = new ArrayList<>();
        Map<String,Float> topemployees = evaluateAllSessions();
        emp_discipline_rating = EvaluatorComparator.entriesSortedByValues(topemployees);
        String display = "";
        for(int i =0 ; i<employeeshow ; i++ ){
            Map.Entry<String, Float> empdetails = emp_discipline_rating.get(0);
            String username = empdetails.getKey();
            Float discipline_rating = empdetails.getValue();
            display = display + username + " - " + discipline_rating  + "\n";
        }
        return display;

    }

    public String bottomEmployees(){
        List<Map.Entry<String, Float>> emp_discipline_rating = new ArrayList<>();
        Map<String,Float> bottomemployees = evaluateAllSessions();
        String display = "";
        emp_discipline_rating = EvaluatorComparator.entriesSortedByValues(bottomemployees);
        for(int i = 1 ; i<=employeeshow ; i++ ){
            Map.Entry<String, Float> empdetails = emp_discipline_rating.get(emp_discipline_rating.size()-i);
            String username = empdetails.getKey();
            Float discipline_rating = empdetails.getValue();
            display = display + username + " - " + discipline_rating  + "\n";
        }
        return display;

    }

    public void CurrEOM(){


    }

    private Map<String, ArrayList<String>> sessionmanager(String username, String minutes,  Map<String, ArrayList<String>> employeesessions) {
        if (!employeesessions.containsKey(username)) {
            ArrayList dailysession = new ArrayList();
            dailysession.add(minutes);
            employeesessions.put(username, dailysession);
        } else {
            ArrayList<String> dailysession = employeesessions.get(username);
            dailysession.add(minutes);
            employeesessions.put(username, dailysession);
        }
        return employeesessions;
    }

    private Map<String, Float> sessionanalysis(Map<String, ArrayList<String>> employeesessions,Map<String, Float> emp_discipline_rating) {
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
        return emp_discipline_rating;

    }

    private int sessionrate(String minutes) {
        int session_minutes = Integer.parseInt(minutes);
        int difference = maximumsession - session_minutes;
        int rating_differential = difference % 10;
        int finalrating = maxrating - rating_differential + 1;
        return finalrating;
    }
}


