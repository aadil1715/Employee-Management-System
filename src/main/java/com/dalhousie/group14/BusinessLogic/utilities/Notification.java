package com.dalhousie.group14.BusinessLogic.utilities;

public class Notification {
    String msg;
    int seen;
    priority p;

    public Notification(){

    }

    public Notification(String msg, String priorityLevel){
        this.setMsg(msg);
        this.setSeen(0);
        this.setPriority(priorityLevel);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getPriority() {
        return String.valueOf(p);
    }

    public void setPriority(String priorityLevel) {
        if (priorityLevel.toLowerCase().contains("low"))
            p = priority.LOW;
        else if (priorityLevel.toLowerCase().contains("medium"))
            p = priority.MEDIUM;
        else if (priorityLevel.toLowerCase().contains("high"))
            p = priority.HIGH;
        else
            p = priority.LOW;
    }

    public int getSeen() {
        return this.seen;
    }

    public void setSeen(int x) {
        this.seen = x;
    }

    public void display() {
        System.out.println("There's a new notification for you!");
        System.out.println("Message: " + getMsg());
        System.out.println("Priority: " + getPriority());
    }

    enum priority {LOW, MEDIUM, HIGH}
}


