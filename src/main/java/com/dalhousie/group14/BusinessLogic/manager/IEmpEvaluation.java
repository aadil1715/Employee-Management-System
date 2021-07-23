package com.dalhousie.group14.BusinessLogic.manager;

import java.util.List;
import java.util.Map;

public interface IEmpEvaluation {
  List<Map.Entry<String, Float>> EvaluateAll();

  String EvaluateEmployee(String username);

  String mostDisciplined();

  String leastDisciplined();

  String EoM();
}
