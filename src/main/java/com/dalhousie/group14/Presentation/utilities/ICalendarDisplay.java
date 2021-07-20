package com.dalhousie.group14.Presentation.utilities;

import java.sql.SQLException;

public interface ICalendarDisplay {
    int start_month = 1;
    int total_months = 12;
    void display(int year) throws SQLException;
}
