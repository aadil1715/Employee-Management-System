package com.dalhousie.group14.Presentation.manager;

import com.dalhousie.group14.BusinessLogic.manager.IProjectStatusRetrieve;
import com.dalhousie.group14.BusinessLogic.manager.ProjectStatusRetrieve;
import com.dalhousie.group14.Database.manager.ProjectStatus;

import java.sql.ResultSet;

public class AssignedProjects implements IAssignedProjects {
  @Override
  public void displayFinishedProjects(IProjectStatusRetrieve projectStatusRetrieve){
    ResultSet resultSet = ProjectStatus.checkStatus("Assigned");
    if (resultSet != null) {
      System.out.println("Here are the assigned projects");
      projectStatusRetrieve.projectList(resultSet);
    }else{
      System.out.println("No assigned projects.");
    }
  }
}
