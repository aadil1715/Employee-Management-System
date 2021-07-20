package com.dalhousie.group14.BusinessLogic.employee;

public class CalendarEvent {
    String eventName;
    String eventDescription;
    String eventDate;
    String empID;
    String managerID;
    int createdByManager;

    public CalendarEvent(){
    }

    public CalendarEvent(String eventName, String eventDescription, String eventDate, String empID, String managerID, int createdByManager) {
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.eventDate = eventDate;
        this.empID = empID;
        this.managerID = managerID;
        this.createdByManager = createdByManager;
    }

    public CalendarEvent(String eventName, String eventDescription, String eventDate, String empID) {
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.eventDate = eventDate;
        this.empID = empID;
        this.createdByManager = 0;
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public String getEventDate() {
        return eventDate;
    }

    public String getEmpID() {
        return empID;
    }

    public String getManagerID() {
        return managerID;
    }

    public int getCreatedByManager() {
        return createdByManager;
    }
}
