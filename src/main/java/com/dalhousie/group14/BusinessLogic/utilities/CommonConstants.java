package com.dalhousie.group14.BusinessLogic.utilities;

import java.text.SimpleDateFormat;

public interface CommonConstants {
    public static final String[] suffixes = new String[] { "th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th" };
    public static final String pattern = "yyyy-MM-dd";
    SimpleDateFormat sdf = new SimpleDateFormat(pattern);
}
