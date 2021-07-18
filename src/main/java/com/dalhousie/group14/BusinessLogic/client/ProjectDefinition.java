package com.dalhousie.group14.BusinessLogic.client;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProjectDefinition implements IProjectDefinition {
    public static final String[] suffixes = new String[] { "th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th" };


    public String noreturn(int i) {
        switch (i % 100) {
            case 11:
            case 12:
            case 13:
                return i + "th";
            default:
                return i + suffixes[i % 10];
        }
    }

    public Date datesetter(String date){
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        sdf.setLenient(false);
        try {
            return sdf.parse(date);
        } catch (ParseException e) {
            return null;
        }

    }

}