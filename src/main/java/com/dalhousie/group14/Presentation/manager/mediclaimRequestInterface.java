package com.dalhousie.group14.Presentation.manager;

import com.dalhousie.group14.BusinessLogic.manager.inputValidation;
import com.dalhousie.group14.Database.manager.MediClaim_Approval;
import com.dalhousie.group14.Database.manager.MediClaim_Rejection;
import com.dalhousie.group14.Database.manager.database_mediclaim_requests;

public interface mediclaimRequestInterface {
  database_mediclaim_requests object1 = new database_mediclaim_requests();
  MediClaim_Approval object2 = new MediClaim_Approval();
  MediClaim_Rejection object3 = new MediClaim_Rejection();
  inputValidation object4= new inputValidation();

}
