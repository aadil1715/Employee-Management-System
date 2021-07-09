package com.dalhousie.group14.Database.utilities;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryExecutor {
    public  static ResultSet readData(String query){
        ResultSet resultSet =  null;
        try {
            PreparedStatement preparedStatement  = DbConnection.connectDB().prepareStatement(query);
            if(preparedStatement!=null){
                resultSet = preparedStatement.executeQuery();
                if(resultSet.isBeforeFirst()){
                    return resultSet;
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public static void writeData(String query){
        ResultSet resultSet =  null;
        try {
            PreparedStatement preparedStatement  = DbConnection.connectDB().prepareStatement(query);
            if(preparedStatement!=null){
                preparedStatement.executeUpdate(query);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    }

