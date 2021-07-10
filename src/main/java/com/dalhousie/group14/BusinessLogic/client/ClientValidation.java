package com.dalhousie.group14.BusinessLogic.client;

public interface ClientValidation {
    int low_range = 0;
    int high_range = 4;
    boolean clientinput(int input, int low_range, int high_range);
}
