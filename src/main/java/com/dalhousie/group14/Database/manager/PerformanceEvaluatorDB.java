package com.dalhousie.group14.Database.manager;

import com.dalhousie.group14.Database.utilities.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PerformanceEvaluatorDB {
    public static ResultSet getEmployeeSessions(){
        ResultSet resultSet =  null;
        try {
            Statement statement = DbConnection.connectDB().createStatement();
            if(statement!=null){
                resultSet = statement.executeQuery("Select ");
                if(resultSet.isBeforeFirst()){
                    return resultSet;
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    return null;
    }
}
