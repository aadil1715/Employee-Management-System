package com.dalhousie.group14.BusinessLogic.utilities;

import com.dalhousie.group14.Database.utilities.Insert_credentials;

import java.util.HashMap;

public class Enter_credentials {

    private String password=null;
    private String username=null;
    private String userType=null;
    public void credentials(HashMap<String,String> map)
    {


        if(map.getOrDefault("Password",null)!=null)
        {
            password=map.get("Password");

        }
        if(map.getOrDefault("UserName",null)!=null)
        {
            username=map.get("UserName");

        }
        if(map.getOrDefault("userType",null)!=null)
        {
            userType=map.get("userType");

        }
        if(password!=null && username!=null && userType!=null)
        {
            Insert_credentials ic1=new Insert_credentials();
            ic1.insert_credentials(username,password,userType);
        }
    }
}
