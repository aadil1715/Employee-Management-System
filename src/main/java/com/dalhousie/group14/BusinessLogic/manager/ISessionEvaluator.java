package com.dalhousie.group14.BusinessLogic.manager;

import java.util.Map;

public interface ISessionEvaluator {
  Map<String, Float> evaluateAllSessions();

  Float evaluateEmployeeSession(String userName);

  String topEmployees();

  String bottomEmployees();

  void CurrEOM();
}
