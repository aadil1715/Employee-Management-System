package com.dalhousie.group14.Presentation.manager;

import com.dalhousie.group14.BusinessLogic.manager.IProjectStatusRetrieve;
import com.dalhousie.group14.BusinessLogic.manager.ProjectStatusRetrieve;
import com.dalhousie.group14.Database.manager.ProjectStatus;

import java.sql.ResultSet;

public class FinishedProjects implements IFinishedProjects {

  @Override
  public void displayFinishedProjects(IProjectStatusRetrieve projectStatusRetrieve){
    ResultSet resultSet = ProjectStatus.checkStatus("Finished");
    if (resultSet != null) {
      System.out.println("Here are the finished projects");
      projectStatusRetrieve.projectList(resultSet);
    }else{
      System.out.println("No finished projects.");
    }

  }
}
