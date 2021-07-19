package com.dalhousie.group14.Presentation.manager;

import com.dalhousie.group14.BusinessLogic.manager.ProjectStatusRetrieve;
import com.dalhousie.group14.BusinessLogic.manager.ProjectAssigner;
import com.dalhousie.group14.BusinessLogic.utilities.CommonConstants;
import com.dalhousie.group14.BusinessLogic.utilities.Validations;
import com.dalhousie.group14.Database.manager.ProjectStatus;
import com.dalhousie.group14.Presentation.Common.UserInput;

import java.sql.ResultSet;
import java.util.List;

public class ProjectManagement implements ProjectInterface, CommonConstants {
  int tries = 0;
  boolean exit = false;

  public void projDashboard() {
    int userinput = min;
    boolean correctinput = false;

    System.out.println("Choose the following options from the options. \n" +
        "1. Pending Projects. \n" +
        "2. Assigned Projects. \n" +
        "3. Finished Projects. \n" +
        "4. To go back to the previous screen. \n");
    try{
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

    if(correctinput){
      if(userinput == 1){
        ResultSet resultSet = ProjectStatus.checkStatus("Initiation");
        if (resultSet!=null){
          List<String> pendingprojects = ProjectStatusRetrieve.projectList(resultSet);
          int max_size = displayProjects(resultSet,pendingprojects);
          System.out.println("If you want to assign a pending project to the " +
              "employees, enter the S.No of the specific project.");
          userinput = UserInput.takeInt();
          if(userinput>min && userinput<=max_size){
            ProjectAssigner obj = new ProjectAssigner();
            boolean status = obj.assignproject(pendingprojects.get(userinput-one));
            if(status){
              System.out.println("Successfully Assigned Employees to the Project");
            }else{
              System.out.println("Couldn't assign employees to the project due to unavailability of free employees.");
            }
          }
        } else {
          System.out.println("No pending projects.");
        }
      } else if (userinput == 2) {
        ResultSet resultSet = ProjectStatus.checkStatus("Assigned");
        System.out.println("Here are the assigned projects");
        if (resultSet!=null){
          List<String> pendingprojects = ProjectStatusRetrieve.projectList(resultSet);
          displayProjects(resultSet,pendingprojects);
        }
      } else if (userinput == 3) {
        ResultSet resultSet = ProjectStatus.checkStatus("Finished");
        System.out.println("Here are the finished projects");
        if (resultSet!=null){
          List<String> pendingprojects = ProjectStatusRetrieve.projectList(resultSet);
          displayProjects(resultSet,pendingprojects);
        }

      }
    }
  }
  public boolean assignAny(){
    if(Validations.limitCheck(tries)){
      System.out.println("You have tried all your available attempts, the application will exit.");
    }
    System.out.println("Couldn't complete the project's team due to " +
        "insufficient suitable employees available, assign any employee?" +
        " Press 1 to confirm.");
    int userinput = UserInput.takeInt();
    boolean response = Validations.intVerifier(low_limit,low_limit,userinput);
    if(response){
      return true;
    }else{
      System.out.println("Wrong input entered, try again.");
      tries++;
      assignAny();
    }
    return false;
  }

  public int displayProjects(ResultSet resultSet, List<String> projectList){
    List<String> pendingprojects = ProjectStatusRetrieve.projectList(resultSet);
    System.out.println("ProjectID | ProjectName | ProjectLanguages | ProjectStartDate" +
        " | ProjectEndDate | ProjectStatus");
    int max_size = pendingprojects.size();
    for(int i = min ; i < pendingprojects.size() ; i++){
      System.out.println(pendingprojects.get(i));
    }

    return max_size;
  }
}
