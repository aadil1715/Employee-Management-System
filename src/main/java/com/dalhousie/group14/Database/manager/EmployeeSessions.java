package com.dalhousie.group14.Database.manager;

import com.dalhousie.group14.Database.utilities.DbConnection;
import com.dalhousie.group14.Database.utilities.QueryExecutor;

import java.sql.*;

public class EmployeeSessions {
    public static ResultSet getEmployeeSessions(){
        ResultSet resultSet =  null;
        String query = "";
        resultSet = QueryExecutor.readData(query);
    return resultSet;
    }



    public static ResultSet getEmployeeSession(String username){
        ResultSet resultSet =  null;
        String query = "";
        resultSet = QueryExecutor.readData(query);
        return resultSet;
    }
}
