package com.dalhousie.group14.BusinessLogic.manager;

import com.dalhousie.group14.Presentation.manager.mediclaimRequestInterface;
import com.dalhousie.group14.Presentation.manager.mediclaim_requests;

public class inputValidation implements mediclaimRequestInterface {

  public void validateInput(String input) {
    if (!input.equalsIgnoreCase("Y") || !input.equalsIgnoreCase("N") || input.equals(null)) {
      System.out.println("You have entered bad input.Please try again");
    } else if (input.equals("")) {
      System.out.println("You have entered nothing.Please try again");
    } else {

    }
  }

  public void validateNameRequestApproval(String name) {
    if (name.matches("[a-zA-Z]+")) {
      System.out.println("You have entered the name " + name + " for the mediclaim request approval");
      object2.approveStatus(name);

    } else {
      System.out.println("you have entered bad input.Please try again");
      mediclaim_requests object1 = new mediclaim_requests();
      object1.display_mediclaim_requests();
    }
  }

  public void validateNameRequestRejection(String name) {
    if (name.matches("[a-zA-Z]+")) {
      System.out.println("You have entered the name " + name + " for the mediclaim request rejection");
      object3.rejectStatus(name);

    } else {
      System.out.println("you have entered bad input.Please try again");
      mediclaim_requests object1 = new mediclaim_requests();
      object1.display_mediclaim_requests();
    }
  }

}
