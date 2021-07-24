package com.dalhousie.group14.BusinessLogic.manager;

public interface IInputValidation {
  boolean validateSwitchCase(int input);
  boolean validateInput(String input);
  void validateNameRequestApproval(String name);
  void validateNameRequestRejection(String name);

}
