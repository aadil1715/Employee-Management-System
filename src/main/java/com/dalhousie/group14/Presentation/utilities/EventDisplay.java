package com.dalhousie.group14.Presentation.utilities;

import com.dalhousie.group14.BusinessLogic.employee.CalendarEvent;

public class EventDisplay {
    public void display(CalendarEvent e){
        System.out.println("Event Name : " + e.getEventName());
        System.out.println("Event Description : " +e.getEventDescription());
        System.out.println("Event Date : " + e.getEventDate());
    }
}
