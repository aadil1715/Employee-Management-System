package com.dalhousie.group14.Presentation.manager;

import com.dalhousie.group14.Database.manager.DatabaseMediclaimRequests;
import com.dalhousie.group14.Database.manager.IManagerDatabaseMediclaimRequests;

public class DisplayUpdatedMediclaimRequests  implements IDisplayUpdatedMediclaimRequests{

  public void displayUpdatedMediclaimRequests() {
    IManagerDatabaseMediclaimRequests mediclaimrequestsdb =
        new DatabaseMediclaimRequests();
    System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t----------Below is the " +
        "updated list of Mediclaim Requests----------\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" +
            "\t");
    System.out.printf("%15s %30s %30s %30s %30s %30s", "NAME", "POLICY " +
        "NUMBER", "MEDICAL ID", "MONEY CLAIMED", "REASON", "APPROVED STATUS\n");
    mediclaimrequestsdb.displayMediclaimRequestsManager();
  }

}
