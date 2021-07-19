package com.dalhousie.group14.Presentation.manager;

import com.dalhousie.group14.BusinessLogic.manager.PendingProjects;
import com.dalhousie.group14.Database.manager.ProjectStatus;
import com.dalhousie.group14.Presentation.Common.UserInput;

import java.sql.ResultSet;
import java.util.List;

public class ProjectManagement implements ProjectInterface {

  public void projDashboard() {
    int userinput = 0;
    boolean correctinput = false;

    System.out.println("Choose the following options from the options. \n" +
        "1. Pending Projects. \n" +
        "2. Assigned Projects. \n" +
        "3. Finished Projects. \n" +
        "4. To go back to the previous screen. \n");
    try {
      userinput = UserInput.takeInt();
      if (userinput > low_limit && userinput <= high_limit) {
        correctinput = true;
      } else {
        System.out.println("Wrong Input Choice.");
        projDashboard();
      }
    } catch (NumberFormatException e) {
      System.out.println("You can only enter an integer value");
    }

    if (correctinput) {
      if (userinput == 1) {
        ResultSet resultSet = ProjectStatus.checkStatus("Initiation");
        if (resultSet != null) {
          PendingProjects.unassignedProjects(resultSet);

        } else if (userinput == 2) {

        } else if (userinput == 3) {

        }
      }
    }
  }
}
