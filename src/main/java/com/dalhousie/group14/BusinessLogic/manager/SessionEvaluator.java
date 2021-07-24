package com.dalhousie.group14.BusinessLogic.manager;

import com.dalhousie.group14.BusinessLogic.utilities.Validations;
import com.dalhousie.group14.Database.manager.EmployeeSessions;
import com.dalhousie.group14.Presentation.utilities.TableFormatter;

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


    public Map<String, Float> evaluateAllSessions() {
        Map<String, List<String>> employeesessions = new HashMap<>();
        Map<String, Float> emp_discipline_rating = new HashMap<>();
        Calendar calendar = Calendar.getInstance();
        sdf.setLenient(false);
        Date final_date = Validations.datesetter(sdf.format(calendar.getTime()));
        ResultSet resultset = EmployeeSessions.getEmployeeSessions(final_date
            ,DAYS);
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

    public Float evaluateEmployeeSession(String userName){
        float notPresent = -1;
        Map<String, List<String>> employeesessions = new HashMap<>();
        Map<String, Float> empDisciplineRating = new HashMap<>();
        Calendar calendar = Calendar.getInstance();

        Date final_date = Validations.datesetter(sdf.format(calendar.getTime()));
        ResultSet resultset = EmployeeSessions.getEmployeeSession(userName,
            final_date, DAYS);
        if(resultset == null){
            return notPresent;
        }
        employeesessions = sessionAdder(resultset,employeesessions);
        empDisciplineRating = sessionAnalysis(employeesessions, empDisciplineRating);

        return empDisciplineRating.get(userName);
    }


    public String topEmployees(){
        List<Map.Entry<String, Float>> emp_discipline_rating;
        Map<String,Float> topemployees = evaluateAllSessions();

        emp_discipline_rating = EvaluatorComparator.entriesSortedByValues(topemployees);
        List<List<String>> topEmployeesDiscipline = new ArrayList<>();
        List<String> headers = Arrays.asList("Employee ID", "Discipline " +
            "Rating");
        topEmployeesDiscipline.add(headers);
        for(int i = 0; i< EMPLOYEESHOW; i++ ){
            Map.Entry<String, Float> empdetails = emp_discipline_rating.get(i);
            String username = empdetails.getKey();
            Float discipline_rating = empdetails.getValue();
            List<String> row = Arrays.asList(username,String.valueOf(discipline_rating));
            topEmployeesDiscipline.add(row);
        }

        return TableFormatter.formatAsTable(topEmployeesDiscipline);
    }


    public String bottomEmployees(){
        List<Map.Entry<String, Float>> emp_discipline_rating;
        Map<String,Float> bottomemployees = evaluateAllSessions();

        emp_discipline_rating = EvaluatorComparator.entriesSortedByValues(bottomemployees);
        List<List<String>> bottomEmployeesDiscipline = new ArrayList<>();
        List<String> headers = Arrays.asList("Employee ID", "Discipline " +
            "Rating");
        bottomEmployeesDiscipline.add(headers);
        for(int i = 1; i<= EMPLOYEESHOW; i++ ){
            Map.Entry<String, Float> empdetails = emp_discipline_rating.get(emp_discipline_rating.size()-i);
            String username = empdetails.getKey();
            Float discipline_rating = empdetails.getValue();
            List<String> row = Arrays.asList(username,String.valueOf(discipline_rating));
            bottomEmployeesDiscipline.add(row);
        }

        return TableFormatter.formatAsTable(bottomEmployeesDiscipline);
    }


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
        List<String>> employeeSessions, Map<String, Float> emp_discipline_rating) {
        Set<String> keyset = employeeSessions.keySet();
        for (String s : keyset) {
            List<String> monthsessions = employeeSessions.get(s);
            float commulitativeRating = 0;
            int maxRating = 0;
            for (int i = 0; i < monthsessions.size(); i++) {
                String minutes = monthsessions.get(i);
                if (minutes != null) {
                    maxRating = maxRating + MAX_RATING;
                    float day_rating = sessionRate(minutes);
                    commulitativeRating = commulitativeRating + day_rating;
                }
            }
            float employee_rating = commulitativeRating/maxRating;
            employee_rating = employee_rating * 10;
            employee_rating = ((int) ((employee_rating + 0.005f) * 100)) / 100f;
            emp_discipline_rating.put(s, employee_rating);
        }

        return emp_discipline_rating;
    }

    private float sessionRate(String minutes) {
        int session_minutes = Integer.parseInt(minutes);
        int difference = MAXIMUM_SESSION - session_minutes;
        float rating_differential = difference / MAX_RATING;
        if (rating_differential > 10){
            return 0;
        }
        return MAX_RATING - rating_differential;
    }


}


