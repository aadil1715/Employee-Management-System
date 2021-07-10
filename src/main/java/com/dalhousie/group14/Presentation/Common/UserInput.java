package com.dalhousie.group14.Presentation.Common;

import java.util.Scanner;

public class UserInput {
    static Scanner sc = new Scanner(System.in);

    public static int takeInt(){
        return sc.nextInt();
    }
    public static String takeString(){
        return sc.next();
    }
}
