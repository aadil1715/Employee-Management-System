package com.dalhousie.group14.BusinessLogic.client;

public class ClientDashboardValidation {

    public boolean clientinput(int input){
        if (input > 0 && input < 4) {
            boolean correctoption = true;
            return true;
        }
        return false;
    }
}
