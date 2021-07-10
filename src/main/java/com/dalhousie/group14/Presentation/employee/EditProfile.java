package com.dalhousie.group14.Presentation.employee;

import java.util.Scanner;
import static com.dalhousie.group14.BusinessLogic.employee.ChangePassword.changePassword;
import static com.dalhousie.group14.BusinessLogic.employee.ChangeSecurityQuestion.changeSecurityQuestion;
import static com.dalhousie.group14.Presentation.employee.EmployeeLoginDashBoard.employeeLoginDashBoard;

public class EditProfile {
    public static void editProfile() {

        Scanner scanner = new Scanner(System.in);
        int number;
        System.out.println("Press 1 for Edit Password: \n " +
                            "Press 2 for Change Security Question: \n " +
                            "Press 3 for Goto the Previous Page:");
        number = scanner.nextInt();
        try {
            //noinspection InfiniteLoopStatement
            do {
                if (number == 1) {
                    changePassword();
                } else if (number == 2) {
                    changeSecurityQuestion();
                } else if (number == 3) {
                    employeeLoginDashBoard();
                } else {
                    System.out.println("Enter Correct Number");
                }

            } while (true);
        } catch (Exception e) {
            //noinspection ThrowablePrintedToSystemOut
            System.out.println(e);
        }
    }
}
