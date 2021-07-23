package com.dalhousie.group14.BusinessLogic.manager;

import java.sql.ResultSet;
import java.util.List;

public interface IProjectStatusRetrieve {
  List<String> projectList(ResultSet resultSet);
}
