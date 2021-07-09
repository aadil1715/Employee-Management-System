package com.dalhousie.group14.BusinessLogic.utilities;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validations {
    public static boolean isStringvalid(String input){
        if(input==null || input.isEmpty()){
            return false;
        }
        Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(input);
        boolean b = m.find();
        return !b;
    }

    public static boolean datecomparison(Date start_date, Date end_date){
        return end_date.after(start_date);
    }

}
