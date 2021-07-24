package com.dalhousie.group14.Database.manager;

import com.dalhousie.group14.Database.utilities.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AssetRequestDB {
  Connection connection=null;
  public AssetRequestDB(){

    connection= DbConnection.connectDB();
  }
  public List<List<String>>getPendingAssetRequestInformation(String managerUserName){
    Statement stmt = null;
    List<List<String>> info = new ArrayList<>();

    try {
      stmt = this.connection.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT * FROM AssetRequest WHERE " +
          "ApprovdStatus='pending';");

      while (rs.next()) {
        List<String> information = new ArrayList<>();
        information.add(rs.getString("EmployeeUserName"));
        information.add(rs.getString("Reason"));
        information.add(rs.getString("ApprovdStatus"));
        information.add(rs.getString("item"));
        info.add(information);

      }

    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return info;



  }

  public boolean setNewAsset(String userName, String type,
                       String value) {
    try {
      Statement stmt = this.connection.createStatement();
      String sql =
          "UPDATE AssetRequest SET " + type + "='" + value + "' WHERE " +
              "EmployeeUserName='" + userName + "';";

      stmt.execute(sql);
      return true;

    } catch (SQLException throwables) {
      throwables.printStackTrace();
      return false;
    }

  }

  public void insertNewAssetRequest(String employeeUserName, String reason,
                                    String item) {
    try {
      Statement statement=this.connection.createStatement();
      String sql=
          "insert into AssetRequest values('"+employeeUserName+"', '"+reason+
              "', 'pending','"+item+"');";
      statement.execute(sql);
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }

  }
}
