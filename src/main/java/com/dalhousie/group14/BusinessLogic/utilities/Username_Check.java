package com.dalhousie.group14.BusinessLogic.utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import  com.dalhousie.group14.Presentation.utilities.login;


public class Username_Check {

    public void username_Check(String name)
    {
        login l=new login();
        // regex to check the valid username
        String regex="^(.+)@(.+)$";
        //Compile the regex
        Pattern p=Pattern.compile(regex);
        Matcher m = p.matcher(name);
        boolean valid = (name != null) && p.matcher(name).matches();

        if(valid)
        {
            System.out.println("username is valid");

        }
        else
        {
            System.out.println("Username is not valid");
            l.login1();
        }



    }
}
