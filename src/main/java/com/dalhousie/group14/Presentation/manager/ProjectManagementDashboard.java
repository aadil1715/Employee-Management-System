package com.dalhousie.group14.Presentation.manager;

import com.dalhousie.group14.BusinessLogic.utilities.Validations;
import com.dalhousie.group14.Presentation.Common.UserInput;

import java.util.InputMismatchException;

public class ProjectManagementDashboard implements IProjectManagementDashboard {
  int tries = 0;
  public static final int MIN = 0;
  public static final int ONE = 1;
  public static final int LOW_LIMIT = 1;
  public static final int HIGH_LIMIT = 4;
  public static final int OPTION_1 = 1;
  public static final int OPTION_2 = 2;
  public static final int OPTION_3 = 3;
  public static final int OPTION_4 = 4;

  public static void main(String[] args) {
    ProjectManagementDashboard obj = new ProjectManagementDashboard();
    obj.projDashboard();
  }

  @Override
  public void projDashboard() {
    int userinput = MIN;
    boolean correctinput = false;

    if (Validations.limitCheck(tries)) {
      System.out.println("EXIT WARNING!");
      System.out.println("You have tried all your available attempts, the application will exit.");
    }

    System.out.println("Choose the following options from the options. \n" +
        "1. Pending Projects. \n" +
        "2. Assigned Projects. \n" +
        "3. Finished Projects. \n" +
        "4. To go back to the previous screen. \n");
    try {
      userinput = UserInput.takeInt();
      if (userinput >= LOW_LIMIT && userinput <= HIGH_LIMIT) {
        correctinput = true;
      } else {
        System.out.println("Wrong Input Choice.");
        tries++;
        projDashboard();
      }
    } catch (InputMismatchException inputMismatchException) {
      System.out.println("You can only enter an integer value, try again.");
      projDashboard();
      tries++;
    }
    if (correctinput) {
      if (userinput == OPTION_1) {
        IPendingProjects obj = new PendingProjects();
        obj.displayPendingProjects();
      }
    } else if (userinput == OPTION_2) {
      IAssignedProjects obj = new AssignedProjects();
      obj.displayFinishedProjects();
    } else if (userinput == OPTION_3) {
      IFinishedProjects obj = new FinishedProjects();
      obj.displayFinishedProjects();
    }
  }

  @Override
  public boolean assignAny() {
    if (Validations.limitCheck(tries)) {
      System.out.println("EXIT WARNING!");
      System.out.println("You have tried all your available attempts, the application will exit.");
      return false;
    }
    System.out.println("Couldn't complete the project's team due to " +
        "insufficient suitable employees available, assign any employee?" +
        " Press 1 to confirm.");
    int userinput = UserInput.takeInt();
    boolean response = Validations.intVerifier(LOW_LIMIT, LOW_LIMIT, userinput);
    if (response) {
      return true;
    } else {
      System.out.println("Wrong input entered, try again.");
      tries++;
      assignAny();
    }
    return false;
  }


  @Override
  public void displayProjects(String projectsString) {
    System.out.println(projectsString);
  }


}
