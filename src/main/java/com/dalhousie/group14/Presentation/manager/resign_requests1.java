package com.dalhousie.group14.Presentation.manager;
import com.dalhousie.group14.Database.manager.resign_requests;

public class resign_requests1 {

    public void display_resign_requests()
    {
        resign_requests rr= new resign_requests();
        System.out.println("-----List of Resignation Requests-----");
        System.out.printf("%10s %15s %30s %35s", "EMPLOYEE ID", "NAME", "DATE OF RESIGNATION", "REASON FOR THE RESIGNATION");
        rr.select_resign_requests();
    }

}