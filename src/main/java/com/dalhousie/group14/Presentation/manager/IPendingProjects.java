package com.dalhousie.group14.Presentation.manager;

import com.dalhousie.group14.BusinessLogic.manager.IProjectStatusRetrieve;

public interface IPendingProjects {
  void displayPendingProjects(IProjectStatusRetrieve projectStatusRetrieve);
}
