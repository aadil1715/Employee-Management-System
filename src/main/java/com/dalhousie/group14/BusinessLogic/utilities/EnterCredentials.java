package com.dalhousie.group14.BusinessLogic.utilities;

import com.dalhousie.group14.Database.utilities.IInsertCredentials;
import com.dalhousie.group14.Database.utilities.IInsertLoginTime;
import com.dalhousie.group14.Database.utilities.InsertLoginCredentials;
import com.dalhousie.group14.Database.utilities.InsertLoginTime;

import java.util.HashMap;

public class EnterCredentials implements IEnterCredentials {

  private String password = null;
  private String username = null;
  private String userType = null;
  private String time = null;


  public void credentials(HashMap<String, String> map) {
    IInsertCredentials insertCredentials = new InsertLoginCredentials();
    IInsertLoginTime insertLoginTime = new InsertLoginTime();

    if (map.getOrDefault("Password", null) != null) {
      password = map.get("Password");

    }
    if (map.getOrDefault("UserName", null) != null) {
      username = map.get("UserName");

    }
    if (map.getOrDefault("userType", null) != null) {
      userType = map.get("userType");

    }
    if (map.getOrDefault("time", null) != null) {
      time = map.get("time");
    }
    if (password != null && username != null && userType != null) {
      insertCredentials.insertLoginCredentials(username, password, userType);
      insertLoginTime.insertLoginTime(time, username);

    }
  }

}
