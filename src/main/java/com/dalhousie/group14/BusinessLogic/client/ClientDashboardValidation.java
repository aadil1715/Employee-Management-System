package com.dalhousie.group14.BusinessLogic.client;
/**
 * @Author: Harjot Singh
 * @NameofFile: ClientDashboardValidation.java
 * @ClassDescription: This class is responsible for
 */
public class ClientDashboardValidation implements IClientDashboardValidation {

    public boolean clientInput(int input, int low_range, int high_range){
        if (input > low_range && input < high_range) {
            return true;
        }
        return false;
    }
}
