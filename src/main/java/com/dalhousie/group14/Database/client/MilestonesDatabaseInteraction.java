package com.dalhousie.group14.Database.client;

import com.dalhousie.group14.BusinessLogic.utilities.CommonConstants;
import com.dalhousie.group14.Database.utilities.QueryExecutor;

import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MilestonesDatabaseInteraction implements CommonConstants {
    public static void insertmilestones(int project_id, Map<Date,String> milestones){
        Set<Date> mdates = milestones.keySet();
        for(Date s : mdates){
            String query = "INSERT INTO milestones (milestoneDesc, ProjectID, Deadline)"+"Values('" + milestones.get(s) + "','" + project_id + "','"+sdf.format(s)+"');";
            QueryExecutor.writeData(query);
        }

    }
}
