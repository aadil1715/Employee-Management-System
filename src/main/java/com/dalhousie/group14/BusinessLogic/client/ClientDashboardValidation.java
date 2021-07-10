package com.dalhousie.group14.BusinessLogic.client;

public class ClientDashboardValidation {

    public boolean clientinput(int input, int low_range, int high_range){
        if (input > low_range && input < high_range) {
            boolean correctoption = true;
            return true;
        }
        return false;
    }
}
