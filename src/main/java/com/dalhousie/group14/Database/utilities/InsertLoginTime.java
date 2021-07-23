package com.dalhousie.group14.Database.utilities;

import java.time.LocalTime;

public class InsertLoginTime  implements IInsertLoginTime{

  public void insertLoginTime(String time, String username) {

    LocalTime localTime = LocalTime.parse(time);
    String query =
        "insert into LoginSession(LoginTime,UserName) values('" + localTime +
            "','" + username +
            "');";
    QueryExecutor.writeData(query);
  }

}
