package com.dalhousie.group14.Database.employee;

import com.dalhousie.group14.Database.utilities.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class EmployeeDBOperation {
    Connection connection=null;
    public EmployeeDBOperation(){

        connection=DbConnection.connectDB();
    }
    public Boolean setEmployee(String username,String type,double value){
        try {
            Statement stmt = this.connection.createStatement();
            String sql="UPDATE Employee SET "+type+"="+value+"WHERE UserName='"+username+"';";
            stmt.execute(sql);
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
    public Map<String,String> getEmployeeInfo(String username){
        Map<String,String>information=new HashMap<String,String>();

        try {
            Statement stmt = this.connection.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT * FROM Employee WHERE UserName='"+username+"';");

            while (rs.next()){
                information.put("UserName",rs.getString("UserName"));
                information.put("ContactName",rs.getString("ContactName"));
                information.put("gender",rs.getString("gender"));
                information.put("DOB",rs.getString("DOB"));
                information.put("basic_salary",rs.getString("Basicsalary"));
                information.put("ctc",rs.getString("CTC"));
                information.put("epf",rs.getString("EPF"));
                information.put("bonus",rs.getString("bonus"));
                information.put("lastmonthsalary",rs.getString("lastmonthsalary"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return  information;

    }

}
