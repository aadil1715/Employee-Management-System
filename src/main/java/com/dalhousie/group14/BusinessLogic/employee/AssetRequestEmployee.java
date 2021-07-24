package com.dalhousie.group14.BusinessLogic.employee;

import com.dalhousie.group14.Database.manager.AssetRequestDB;
import com.dalhousie.group14.Presentation.employee.AssetRequestPresentation;

import java.util.ArrayList;
import java.util.List;

public class AssetRequestEmployee {
  public void ApplyForAssetRequest(String employeeUserName){
    List<String>assets=new ArrayList<>();
    AssetRequestPresentation assetRequestPresentation=
        new AssetRequestPresentation();
    assets=assetRequestPresentation.askForAssets();
    AssetRequestDB assetRequestDB=new AssetRequestDB();

    assetRequestDB.insertNewAssetRequest(employeeUserName,assets.get(0),
        assets.get(1));

  }

}
