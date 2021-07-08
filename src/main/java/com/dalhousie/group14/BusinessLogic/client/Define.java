package com.dalhousie.group14.BusinessLogic.client;

import java.util.Date;

public interface Define {
    String[] suffixes = new String[] { "th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th" };
    String pattern = "yyyy-MM-dd";


    String noreturn(int i);
    Date datesetter(String date);
}
