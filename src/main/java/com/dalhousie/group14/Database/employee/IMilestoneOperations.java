package com.dalhousie.group14.Database.employee;

import java.util.Date;
import java.util.List;

public interface IMilestoneOperations {
    List<String> getMilestone(String empID);
    void completeMilestone(int milestoneID, String empID, Date date);
}
