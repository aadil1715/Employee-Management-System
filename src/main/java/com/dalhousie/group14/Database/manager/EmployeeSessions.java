package com.dalhousie.group14.Database.manager;

import com.dalhousie.group14.BusinessLogic.utilities.CommonConstants;
import com.dalhousie.group14.BusinessLogic.utilities.Validations;
import com.dalhousie.group14.Database.utilities.DbConnection;
import com.dalhousie.group14.Database.utilities.QueryExecutor;
import java.sql.*;
import java.util.Date;


public class EmployeeSessions implements CommonConstants {
    public static ResultSet getEmployeeSessions(Date date){
        ResultSet resultSet =  null;
        Date previous_date = Validations.addDaystoDate(date,30);
        String query = "Select * from LoginSession where SessionDate between '"+sdf.format(previous_date)+"' and '"+sdf.format(date)+"'";
        resultSet = QueryExecutor.readData(query);
    return resultSet;
    }



    public static ResultSet getEmployeeSession(String username, Date date){
        ResultSet resultSet =  null;
        Date previous_date = Validations.addDaystoDate(date,30);
        String query = "Select * from LoginSession where SessionDate between '"+sdf.format(previous_date)+"' and '"+sdf.format(date)+"' AND UserName='"+username+"'";
        resultSet = QueryExecutor.readData(query);
        return resultSet;
    }
}
