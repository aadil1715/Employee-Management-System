package com.dalhousie.group14.BusinessLogic.utilities;

import com.dalhousie.group14.Project;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validations implements CommonConstants {
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

    public static Date addDaystoDate(Date date, int days){
        Calendar c = Calendar.getInstance();
        c.setTime(date); // Using today's date
        c.add(Calendar.DATE, days); // Adding 5 days
        Date updatedate = c.getTime();
        return updatedate;
    }

    public static Date subtractDaystoDate(Date date, int days){
        Calendar c = Calendar.getInstance();
        c.setTime(date);// Using today's date
        c.add(Calendar.DATE, -days);
        Date updatedate = c.getTime();
        return updatedate;
    }

    public static Date datesetter(String date){

        try{

            return sdf.parse(date);

        }catch (ParseException e){
            System.out.println("Invalid Date format - Follow YYYY-MM-dd Format.");

        }

        return null;
    }

    public static String noreturn(int i) {
        String[] suffixes = new String[] { "th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th" };
        switch (i % 100) {
            case 11:
            case 12:
            case 13:
                return i + "th";
            default:
                return i + suffixes[i % 10];

        }
    }

}
