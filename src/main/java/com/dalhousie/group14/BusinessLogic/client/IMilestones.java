package com.dalhousie.group14.BusinessLogic.client;

import java.util.Date;
import java.util.Map;

public interface IMilestones {
  Map<Date, String> definemilestones(Integer m_no, Date start_date, Date end_date, Date milestone_date, String milestone_desc);
}
