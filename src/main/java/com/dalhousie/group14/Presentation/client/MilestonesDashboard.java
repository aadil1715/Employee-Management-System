package com.dalhousie.group14.Presentation.client;

import com.dalhousie.group14.BusinessLogic.client.Milestones;
import com.dalhousie.group14.BusinessLogic.utilities.Validations;

import java.util.*;

public class MilestonesDashboard implements MilestoneProperties {


    public Map<Date,String> definemilestonescreen(Date start_date, Date end_date) {
        boolean m1 = false;
        int mcount = 1;
        int tries = 0;
        Map<Date, String> received = new HashMap<>();
        Milestones obj = new Milestones();
        while (mcount != milestone_limit || tries != max_tries) {
            Scanner sc = new Scanner(System.in);
            System.out.println();
            System.out.print("Enter the " + Validations.noreturn(mcount) + " Milestone's Description : ");
            String milestone_desc = sc.nextLine();
            System.out.print("Enter the " + Validations.noreturn(mcount) + " Milestone's Deadline Date : ");
            String milestone1_date = sc.nextLine();
            Date milestone_date = Validations.datesetter(milestone1_date);
            if (milestone_date != null) {
                received = obj.definemilestones(mcount, start_date, end_date, milestone_date, milestone_desc);
                if (received != null) {
                    mcount++;
                }
            }
            tries++;
            if (tries == max_tries) {
                System.out.println("Maximum Input Tries Limit Reached, Program will exit.");
            }
            if (mcount > milestone_limit) {
                return received;

            }
        }
        return null;
    }

}

