package com.dalhousie.group14.Database.utilities;
//D of SOLID if we want to change the database
import java.util.Map;

public interface DataStorage {
    Map<String,String> getEmployeeInfo(String username);


}
