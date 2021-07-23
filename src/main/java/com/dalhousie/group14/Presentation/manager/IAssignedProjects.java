package com.dalhousie.group14.Presentation.manager;

import com.dalhousie.group14.BusinessLogic.manager.IProjectStatusRetrieve;

public interface IAssignedProjects {
  void displayFinishedProjects(IProjectStatusRetrieve projectStatusRetrieve);
}
