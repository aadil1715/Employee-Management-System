package com.dalhousie.group14.Database.manager;

import com.dalhousie.group14.BusinessLogic.utilities.Validations;
import com.dalhousie.group14.Database.utilities.QueryExecutor;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;


public class EmployeeSessions {
    public static final String pattern = "yyyy-MM-dd";
    public static final SimpleDateFormat sdf = new SimpleDateFormat(pattern);

    public static ResultSet getEmployeeSessions(Date date, int DAYS){
        ResultSet resultSet =  null;
        Date previous_date = Validations.addDaystoDate(date,-DAYS);
        String query = "Select * from LoginSession where SessionDate between '"
            +sdf.format(previous_date)+"' and '"+sdf.format(date)+"'";
        resultSet = QueryExecutor.readData(query);
    return resultSet;
    }



    public static ResultSet getEmployeeSession(String username, Date date,
                                               int DAYS){
        ResultSet resultSet =  null;
        Date previous_date = Validations.addDaystoDate(date,-DAYS);
        String query = "Select * from LoginSession where SessionDate between '"
            +sdf.format(previous_date)+"' and '"+sdf.format(date)+"' AND UserName='"+username+"'";
        resultSet = QueryExecutor.readData(query);
        return resultSet;
    }
}
