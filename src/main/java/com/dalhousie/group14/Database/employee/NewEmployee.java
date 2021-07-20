package com.dalhousie.group14.Database.employee;

import com.dalhousie.group14.Database.utilities.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NewEmployee {
  Connection connection=null;
  public NewEmployee(){

    connection= DbConnection.connectDB();
  }

  public Boolean setNewEmployee(String username, String type, String value){
    try {
      Statement stmt = this.connection.createStatement();
      String sql=
              "UPDATE joinrequest SET "+type+"='"+value+"' WHERE " +
                      "TempUserName='"+username+"';";
      stmt.execute(sql);
      return true;
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return false;
  }
  public void deleteTemporaryUser(String UserName){
    Statement stmt = null;
    try {
      stmt = this.connection.createStatement();
      stmt.execute("delete from joinrequest where TempUserName='"+UserName+"';");
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }
  public boolean setEmployee(Map<String,String>map){

    Statement stmt = null;
    try {
      stmt = this.connection.createStatement();
      String sql=
              "insert into Employee (UserName ,ContactName ,gender ,DOB ," +
                      "Basicsalary ,CTC ,bonus ,lastmonthsalary ,EPF ,ProjectHistory) " +
                      "values" +
                      "('"+map.get("UserName")+"', '"+map.get("ContactName")+
              "', '"+map.get("gender")+"', '"+map.get("DOB")+"', '"+map.get(
                      "Basicsalary")+
                      "', '"+map.get("CTC")+
                      "', '0', '0', '"+map.get("EPF")+"','null');";
      System.out.println(sql);
      stmt.execute(sql);
      return true;
    } catch (SQLException throwables) {
      throwables.printStackTrace();
      return false;
    }
  }
  public boolean setLoginInfo(String userName,String Password){
    Statement stmt = null;
    try {
      stmt = this.connection.createStatement();
      String sql="Insert into LoginInfo values ('"+userName+"', '"+Password+
              "'," +
            "'Employee" +
              "');";
      stmt.execute(sql);
      return true;
    } catch (SQLException throwables) {
      return false;
    }
  }
  public List<List<String>> getPendingNewEmployeeInfo(){
    Statement stmt = null;
    List<List<String>>info=new ArrayList<>();
    List<String>information=new ArrayList<>();
    try {
      stmt = this.connection.createStatement();
      ResultSet rs=stmt.executeQuery("SELECT * FROM joinrequest WHERE " +
              "approvalstatus='pending';");

      while (rs.next()) {
        information.add(rs.getString("TempUserName"));
        information.add( rs.getString("ContactName"));
        information.add( rs.getString("gender"));
        information.add( rs.getString("DOB"));
        information.add(rs.getString("approvedBasicsalary"));
        information.add(rs.getString("approvedCTC"));
        information.add( rs.getString("approvedEPF"));
        information.add(rs.getString("requestedUserName"));
        information.add(rs.getString("requestedPassword"));


      }
      info.add(information);
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return  info;

  }

  public Map<String,String> getNewEmployeeInfo(String username)  {
    Statement stmt = null;
    Map<String,String>information=new HashMap<String,String>();
    try {
      stmt = this.connection.createStatement();
      ResultSet rs=stmt.executeQuery("SELECT * FROM joinrequest WHERE " +
              "TempUserName='"+username+"';");

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



