package com.dalhousie.group14.Presentation.client;

import com.dalhousie.group14.Database.client.IProjectDatabaseInteraction;

public interface IClientProject {
  boolean defineproject(String clientID);

  boolean defineProjectName(IProjectDatabaseInteraction projectDatabaseInteraction);

  boolean defineProjectLanguages();

  boolean defineProjectDates();

  boolean defineProjectMilestones(IProjectDatabaseInteraction projectDatabaseInteraction, String clientID);
}
