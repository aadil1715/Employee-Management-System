package com.dalhousie.group14.Presentation.manager;

import com.dalhousie.group14.Database.manager.database_asset_requests;

public class asset_requests {

  public void display_asset_requests() {
    database_asset_requests ar = new database_asset_requests();
    System.out.println("-----List of Asset Requests-----");
    System.out.printf("%10s %15s %30s %35s %30s %30s %30s", "EMPLOYEE ID", "MANAGER ID", "REQUEST ID", "ASSET NAME", "REQUEST DATE", "REASON", "APPROVED STATUS\n");
    ar.select_asset_requests();
  }

}
