package com.dalhousie.group14.BusinessLogic.utilities;

import java.text.SimpleDateFormat;

public interface CommonConstants {
    public static final String[] suffixes = new String[] { "th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th" };
    public static final String pattern = "yyyy-MM-dd";
    SimpleDateFormat sdf = new SimpleDateFormat(pattern);
    int min = 0;
    int one = 1;
    int languages = 3;
    int name = 2;
    int completeassigned = 3;
    int maxtries = 3;
    int ID = 1;
}
