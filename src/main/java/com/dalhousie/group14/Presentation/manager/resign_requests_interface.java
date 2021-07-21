package com.dalhousie.group14.Presentation.manager;

import com.dalhousie.group14.BusinessLogic.manager.inputValidation;
import com.dalhousie.group14.Database.manager.*;

public interface resign_requests_interface {

  approved_status object1 = new approved_status();

  rejected_status object2 = new rejected_status();

  database_resign_requests object3 = new database_resign_requests();

  insert_Manager_ID insert_manager_id = new insert_Manager_ID();

  get_manager_id getManagerId = new get_manager_id();

  inputValidation object4 = new inputValidation();

  void display_resign_requests();

  void displayUpdatedList();

}
