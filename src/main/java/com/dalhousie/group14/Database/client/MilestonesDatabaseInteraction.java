package com.dalhousie.group14.Database.client;

import com.dalhousie.group14.Database.utilities.QueryExecutor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Set;

public class MilestonesDatabaseInteraction implements IMilestonesDatabaseInteraction {
  public static final String pattern = "yyyy-MM-dd";
  public static final SimpleDateFormat sdf = new SimpleDateFormat(pattern);

}
