package com.dalhousie.group14.BusinessLogic.manager;

import java.util.List;
import java.util.Set;

public interface IProjectAssigner {

  String assignProject(String projectInfo);

  Set<String> empAssigner(List<String> requiredlanguages);

  boolean assignPerfectFit(List<String> requiredlanguages);

  boolean assignDuoFit(List<String> requiredlanguages);

  boolean assignSingleFit(List<String> singleFitemployees);

  boolean assignAnyFit();

  List<String> languageformatter(String languages);

}
