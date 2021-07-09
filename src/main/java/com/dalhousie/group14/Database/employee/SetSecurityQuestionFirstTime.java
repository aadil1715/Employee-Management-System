package com.dalhousie.group14.Database.employee;


import java.sql.Statement;
import java.util.Scanner;

import static com.dalhousie.group14.Database.utilities.DbConnection.connectDB;
import static com.dalhousie.group14.Database.utilities.DbConnection.connection;

public class SetSecurityQuestionFirstTime {

    public static void setSecurityQuestionFirstTime(String username){
        String query;
        Scanner scanner= new Scanner(System.in);
        String question1,question2,question3;
        Statement statement;
        int result;
        System.out.println("Enter 1 Security Question");
        question1=scanner.nextLine();
        System.out.println("Enter 2 Security Question");
        question2=scanner.nextLine();
        System.out.println("Enter 3 Security Question");
        question3=scanner.nextLine();

        query=("insert into securityquestion (UserName,securityQuestion1,securityQuestion2,securityQuestion3)" +
                "values('" + username + "','" + question1 + "','" + question2 + "','" + question3 + "')");
        try {
            connectDB();
            statement= connection.createStatement();
            result=statement.executeUpdate(query);
            if (result > 0)
                System.out.println("successfully inserted");
            else
                System.out.println("Data not Inserted!! please, check your Username ");
        }catch (Exception e){
            System.out.println("Exception:"+e);
        }
    }
}
