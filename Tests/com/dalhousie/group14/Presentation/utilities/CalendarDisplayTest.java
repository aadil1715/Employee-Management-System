package com.dalhousie.group14.Presentation.utilities;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalendarDisplayTest {
    @Test
    public void display() {
        CalendarDisplay cd = new CalendarDisplay();
        cd.display(2020);
    }
}