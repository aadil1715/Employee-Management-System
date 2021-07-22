package com.dalhousie.group14.Presentation.manager;

import com.dalhousie.group14.BusinessLogic.manager.ProjectAssigner;
import com.dalhousie.group14.BusinessLogic.manager.ProjectStatusRetrieve;
import com.dalhousie.group14.Database.manager.ProjectStatus;
import com.dalhousie.group14.Presentation.Common.UserInput;

import java.sql.ResultSet;
import java.util.List;

public class PendingProjects implements IPendingProjects {
  public static final int MIN = 0;
  public static final int ONE = 1;

  @Override
  public void displayPendingProjects() {
    int max_size = 0;
    int userinput;
    ResultSet resultSet = ProjectStatus.checkStatus("Initiation");
    if (resultSet != null) {
      List<String> pendingprojects = ProjectStatusRetrieve.projectList(resultSet);
      if(pendingprojects!=null) {
        max_size = pendingprojects.size();
      }
      if (max_size == MIN) {
        System.out.println("Couldn't find any pending projects at this " +
            "time.");
      } else {
        System.out.println("If you want to assign a pending project to the " +
            "employees, enter the S.No of the specific project.");
        userinput = UserInput.takeInt();
        if (userinput > MIN && userinput <= max_size) {
          ProjectAssigner obj = new ProjectAssigner();
          boolean status = obj.assignProject(pendingprojects.get(userinput - ONE));
          if (status) {
            System.out.println("Successfully Assigned Employees to the Project");
          } else {
            System.out.println("Couldn't assign employees to the project due to unavailability of free employees.");
          }
        }
      }
    } else {
      System.out.println("No pending projects.");

    }
  }
}
