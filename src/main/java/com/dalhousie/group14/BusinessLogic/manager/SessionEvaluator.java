package com.dalhousie.group14.BusinessLogic.manager;

import com.dalhousie.group14.BusinessLogic.utilities.Validations;
import com.dalhousie.group14.Database.manager.EmployeeSessions;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class SessionEvaluator implements ISessionEvaluator {
    public static final String pattern = "yyyy-MM-dd";
    public static final SimpleDateFormat sdf = new SimpleDateFormat(pattern);
    public static final int MAXIMUM_SESSION = 360;
    public static final int MAX_RATING = 10;
    public static final int DAYS = 30;
    public static final int EMPLOYEESHOW = 3;

    @Override
    public Map<String, Float> evaluateAllSessions() {
        Map<String, List<String>> employeesessions = new HashMap<>();
        Map<String, Float> emp_discipline_rating = new HashMap<>();
        Calendar calendar = Calendar.getInstance();
        sdf.setLenient(false);
        Date final_date = Validations.datesetter(sdf.format(calendar.getTime()));
        ResultSet resultset = EmployeeSessions.getEmployeeSessions(final_date);
        employeesessions = sessionAdder(resultset,employeesessions);
        emp_discipline_rating = sessionAnalysis(employeesessions,emp_discipline_rating);

        return  emp_discipline_rating;
    }

    private Map<String, List<String>> sessionAdder(ResultSet resultset, Map<String, List<String>> employeesessions){
        if (resultset != null) {
            while (true) {
                try {
                    if (!resultset.next()) {
                        break;
                    }
                    String username = resultset.getString("UserName");
                    String session_time = resultset.getString("Minutes");
                    employeesessions = sessionManager(username,session_time, employeesessions);

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

        return employeesessions;
    }

    @Override
    public Float evaluateEmployeeSession(String userName){
        Map<String, List<String>> employeesessions = new HashMap<>();
        Map<String, Float> emp_discipline_rating = new HashMap<>();
        Calendar calendar = Calendar.getInstance();

        Date final_date = Validations.datesetter(sdf.format(calendar.getTime()));
        ResultSet resultset = EmployeeSessions.getEmployeeSession(userName, final_date);
        employeesessions = sessionAdder(resultset,employeesessions);
        emp_discipline_rating = sessionAnalysis(employeesessions,emp_discipline_rating);

        return emp_discipline_rating.get(userName);
    }

    @Override
    public String topEmployees(){
        List<Map.Entry<String, Float>> emp_discipline_rating;
        Map<String,Float> topemployees = evaluateAllSessions();

        emp_discipline_rating = EvaluatorComparator.entriesSortedByValues(topemployees);
        String display = "";
        for(int i = 0; i< EMPLOYEESHOW; i++ ){
            Map.Entry<String, Float> empdetails = emp_discipline_rating.get(0);
            String username = empdetails.getKey();
            Float discipline_rating = empdetails.getValue();
            display = display + username + " - " + discipline_rating  + "\n";
        }

        return display;
    }

    @Override
    public String bottomEmployees(){
        List<Map.Entry<String, Float>> emp_discipline_rating;
        Map<String,Float> bottomemployees = evaluateAllSessions();
        String display = "";

        emp_discipline_rating = EvaluatorComparator.entriesSortedByValues(bottomemployees);
        for(int i = 1; i<= EMPLOYEESHOW; i++ ){
            Map.Entry<String, Float> empdetails = emp_discipline_rating.get(emp_discipline_rating.size()-i);
            String username = empdetails.getKey();
            Float discipline_rating = empdetails.getValue();
            display = display + username + " - " + discipline_rating  + "\n";
        }
        
        return display;
    }

    @Override
    public void CurrEOM(){


    }

    private Map<String, List<String>> sessionManager(String username, String minutes, Map<String,
        List<String>> employeesessions) {
        if (!employeesessions.containsKey(username)) {
            List<String> dailysession = new ArrayList<>();
            dailysession.add(minutes);
            employeesessions.put(username, dailysession);
        } else {
            List<String> dailysession = employeesessions.get(username);
            dailysession.add(minutes);
            employeesessions.put(username, dailysession);
        }

        return employeesessions;
    }

    private Map<String, Float> sessionAnalysis(Map<String,
        List<String>> employeesessions, Map<String, Float> emp_discipline_rating) {
        Set<String> keyset = employeesessions.keySet();
        for (String s : keyset) {
            List<String> monthsessions = employeesessions.get(s);
            int cummulitative_rating = 0;
            for (int i = 0; i < monthsessions.size(); i++) {
                String minutes = monthsessions.get(i);
                int day_rating = sessionRate(minutes);
                cummulitative_rating = cummulitative_rating + day_rating;
            }
            float employee_rating = (cummulitative_rating / DAYS) * 100;
            emp_discipline_rating.put(s, employee_rating);
        }

        return emp_discipline_rating;
    }

    private int sessionRate(String minutes) {
        int session_minutes = Integer.parseInt(minutes);
        int difference = MAXIMUM_SESSION - session_minutes;
        int rating_differential = difference % 10;

        return MAX_RATING - rating_differential + 1;
    }
}


