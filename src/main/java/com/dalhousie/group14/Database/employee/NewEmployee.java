package com.dalhousie.group14.Database.employee;

import com.dalhousie.group14.Database.utilities.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class NewEmployee {
  Connection connection=null;
  public NewEmployee(){

    connection= DbConnection.connectDB();
  }
  public Map<String,String> getNewEmployeeInfo(String username)  {
    Statement stmt = null;
    Map<String,String>information=new HashMap<String,String>();
    try {
      stmt = this.connection.createStatement();
      ResultSet rs=stmt.executeQuery("SELECT * FROM joinrequest WHERE UserName='"+username+"';");
      while (rs.next()) {
        information.put("TempUserName", rs.getString("TempUserName"));
        information.put("ContactName", rs.getString("ContactName"));
        information.put("gender", rs.getString("gender"));
        information.put("DOB", rs.getString("DOB"));
        information.put("approvedBasicsalary", rs.getString("approvedBasicsalary"));
        information.put("approvedCTC", rs.getString("approvedCTC"));
        information.put("approvedEPF", rs.getString("approvedEPF"));
        information.put("Password", rs.getString("password"));

      }
      } catch (SQLException throwables) {
        throwables.printStackTrace();
      }
    return  information;

    }
  }



