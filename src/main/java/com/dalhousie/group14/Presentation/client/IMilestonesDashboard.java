package com.dalhousie.group14.Presentation.client;

import java.util.Date;
import java.util.Map;

public interface IMilestonesDashboard {
  Map<Date, String> definemilestonescreen(Date start_date, Date end_date);
}
